package addstrings

// Time:  O(n)
// Space: O(1)

class Solution {
    fun addStrings(num1: String, num2: String): String {
        val result = StringBuilder()
        var i = num1.length - 1
        var j = num2.length - 1
        var carry = 0
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1[i--] - '0'
            }
            if (j >= 0) {
                carry += num2[j--] - '0'
            }
            result.append(carry % 10)
            carry /= 10
        }
        return result.reverse().toString()
    }
}
