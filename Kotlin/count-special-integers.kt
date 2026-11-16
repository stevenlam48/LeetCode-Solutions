package countspecialintegers

// Time:  O(logn)
// Space: O(logn)

// combinatorics
class Solution {
    fun countSpecialNumbers(n: Int): Int {
        val p = { m: Int, nn: Int ->
            var result = 1
            var mm = m
            var k = nn
            while (k-- > 0) {
                result *= mm--
            }
            result
        }

        val digits = (n + 1).toString()
        var result = 0
        for (i in 1 until digits.length) {
            result += p(9, 1) * p(9, i - 1)
        }
        val lookup = HashSet<Int>()
        for (i in digits.indices) {
            for (d in (if (i == 0) 1 else 0) until (digits[i] - '0')) {
                if (lookup.contains(d)) {
                    continue
                }
                result += p(9 - i, digits.length - i - 1)
            }
            if (lookup.contains(digits[i] - '0')) {
                break
            }
            lookup.add(digits[i] - '0')
        }
        return result
    }
}
