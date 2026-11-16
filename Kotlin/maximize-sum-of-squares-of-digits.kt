package maximizesumofsquaresofdigits

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSumOfSquares(num: Int, sum: Int): String {
        if (num.toLong() * 9 < sum) {
            return ""
        }

        val result = CharArray(num) { '0' }
        val q = sum / 9
        val r = sum % 9
        for (i in 0 until q) {
            result[i] = '9'
        }
        if (r != 0) {
            result[q] = '0' + r
        }
        return String(result)
    }
}
