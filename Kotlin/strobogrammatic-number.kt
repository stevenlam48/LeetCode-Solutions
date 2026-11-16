package strobogrammaticnumber
// Time:  O(n)
// Space: O(1)

class Solution {
    fun isStrobogrammatic(num: String): Boolean {
        for (i in 0 until (num.length + 1) / 2) {
            val rotated = lookup[num[num.length - 1 - i]] ?: return false
            if (num[i] != rotated) {
                return false
            }
        }
        return true
    }

    private val lookup = mapOf('0' to '0', '1' to '1', '6' to '9', '8' to '8', '9' to '6')
}
