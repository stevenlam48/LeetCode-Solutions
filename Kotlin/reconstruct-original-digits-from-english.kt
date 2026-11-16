package reconstructoriginaldigitsfromenglish

// Time:  O(n)
// Space: O(1)

class Solution {
    fun originalDigits(s: String): String {
        val numbers = arrayOf(
            "zero", "one", "two", "three",
            "four", "five", "six", "seven",
            "eight", "nine"
        )
        val cnts = Array(numbers.size) { IntArray(26) }
        for (i in numbers.indices) {
            for (c in numbers[i]) {
                ++cnts[i][c - 'a']
            }
        }

        val order = intArrayOf(0, 2, 4, 6, 8, 1, 3, 5, 7, 9)

        val uniqueChars = charArrayOf('z', 'o', 'w', 't', 'u', 'f', 'x', 's', 'g', 'n')
        val cnt = IntArray(26)
        for (c in s) {
            ++cnt[c - 'a']
        }

        val result = StringBuilder()
        for (i in order) {
            while (cnt[uniqueChars[i] - 'a'] > 0) {
                for (j in cnt.indices) {
                    cnt[j] -= cnts[i][j]
                }
                result.append(('0' + i))
            }
        }
        return result.toString().toCharArray().sorted().joinToString("")
    }
}
