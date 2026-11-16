package maximumbinarystringafterchange

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumBinaryString(binary: String): String {
        val chars = binary.toCharArray()
        var zeros = 0
        var ones = 0
        for (i in chars.indices) {
            val c = chars[i]
            if (c == '0') {
                ++zeros
            } else if (zeros == 0) {
                ++ones
            }
            chars[i] = '1'
        }
        if (ones != chars.size) {
            chars[ones + zeros - 1] = '0'
        }
        return String(chars)
    }
}
