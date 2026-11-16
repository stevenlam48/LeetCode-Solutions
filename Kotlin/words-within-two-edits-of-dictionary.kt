package wordswithintwoeditsofdictionary

// Time:  O(25 * l * (n + q))
// Space: O(25 * l * n)

class Solution {
    fun twoEditWords(queries: List<String>, dictionary: List<String>): List<String> {
        val mod = ULong.MAX_VALUE - 58uL
        val base = 113uL
        val powers = mutableListOf(1uL)

        fun add(a: ULong, initialB: ULong): ULong {
            var b = initialB
            if (mod - a <= b) b -= mod
            return a + b
        }

        fun sub(a: ULong, b: ULong): ULong = add(a, mod - b)

        fun multiply(initialA: ULong, initialB: ULong): ULong {
            var a = initialA
            var b = initialB
            var result = 0uL
            if (a < b) {
                val temporary = a
                a = b
                b = temporary
            }
            while (b > 0uL) {
                if (b % 2uL == 1uL) result = add(result, a)
                a = add(a, a)
                b /= 2uL
            }
            return result
        }

        fun power(i: Int): ULong {
            while (i >= powers.size) powers.add(multiply(powers.last(), base))
            return powers[i]
        }

        val lookup = HashSet<ULong>()
        for (word in dictionary) {
            var hash = 0uL
            for (i in word.indices) {
                hash = add(hash, multiply(sub((word[i] - 'a').toULong(), 0uL), power(i)))
            }
            for (i in word.indices) {
                for (x in 'a'..'z') {
                    if (x == word[i]) continue
                    lookup.add(add(hash, multiply(sub((x - 'a').toULong(), (word[i] - 'a').toULong()), power(i))))
                }
            }
        }

        val result = mutableListOf<String>()
        for (word in queries) {
            var hash = 0uL
            for (i in word.indices) {
                hash = add(hash, multiply(sub((word[i] - 'a').toULong(), 0uL), power(i)))
            }
            for (i in word.indices) {
                var found = false
                for (x in 'a'..'z') {
                    if (x == word[i]) continue
                    val candidate = add(hash, multiply(sub((x - 'a').toULong(), (word[i] - 'a').toULong()), power(i)))
                    if (candidate in lookup) {
                        found = true
                        break
                    }
                }
                if (found) {
                    result.add(word)
                    break
                }
            }
        }
        return result
    }
}
