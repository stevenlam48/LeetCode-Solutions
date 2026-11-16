package multiplystrings

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun multiply(num1: String, num2: String): String {
        val result = CharArray(num1.length + num2.length) { '0' }
        for (i in num1.length - 1 downTo 0) {
            for (j in num2.length - 1 downTo 0) {
                val sum = (num1[i] - '0') * (num2[j] - '0') + (result[i + j + 1] - '0')
                result[i + j + 1] = (sum % 10 + '0'.code).toChar()
                result[i + j] += sum / 10
            }
        }
        val pos = result.indexOfFirst { it != '0' }
        if (pos != -1) {
            return String(result, pos, result.size - pos)
        }
        return "0"
    }
}
