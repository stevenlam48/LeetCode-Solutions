package removetrailingzerosfromastring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun removeTrailingZeros(num: String): String {
        val result = StringBuilder(num)
        while (result.last() == '0') {
            result.deleteCharAt(result.lastIndex)
        }
        return result.toString()
    }
}
