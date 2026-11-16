package numberswithrepeateddigits

// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun numDupDigitsAtMostN(N: Int): Int {
        val digits = (N + 1).toString()
        var result = 0

        for (i in 1 until digits.length) {
            result += P(9, 1) * P(9, i - 1)
        }

        val prefixSet = HashSet<Int>()
        for (i in digits.indices) {
            var d = if (i == 0) 1 else 0
            while (d < digits[i] - '0') {
                if (!prefixSet.contains(d)) {
                    result += P(9 - i, digits.length - i - 1)
                }
                ++d
            }
            if (prefixSet.contains(digits[i] - '0')) {
                break
            }
            prefixSet.add(digits[i] - '0')
        }
        return N - result
    }

    private fun P(m: Int, n: Int): Int {
        var mm = m
        var nn = n
        var result = 1
        while (nn-- > 0) {
            result *= mm--
        }
        return result
    }
}
