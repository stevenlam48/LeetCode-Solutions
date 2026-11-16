package largestoddnumberinstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun largestOddNumber(num: String): String {
        for (i in num.length - 1 downTo 0) {
            if ((num[i] - '0') % 2 != 0) {
                return num.substring(0, i + 1)
            }
        }
        return ""
    }
}
