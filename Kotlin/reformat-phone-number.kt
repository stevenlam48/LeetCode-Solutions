package reformatphonenumber
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reformatNumber(number: String): String {
        val digits = number.toCharArray()
        var srcLen = 0
        for (c in number) {
            if (c in '0'..'9') {
                digits[srcLen++] = c
            }
        }
        val dstLen = srcLen + (srcLen - 1) / 3
        val result = digits.copyOf(dstLen)
        var i = srcLen - 1
        var curr = dstLen - 1
        var l = (3 - srcLen % 3) % 3
        while (i >= 0) {
            if (l != 0 && l % 3 == 0) {
                result[curr--] = '-'
            }
            result[curr--] = result[i]
            --i
            ++l
        }
        if (dstLen >= 3 && result[dstLen - 2] == '-') {
            val temp = result[dstLen - 3]
            result[dstLen - 3] = result[dstLen - 2]
            result[dstLen - 2] = temp
        }
        return String(result)
    }
}
