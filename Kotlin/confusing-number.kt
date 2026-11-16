package confusingnumber
// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun confusingNumber(N: Int): Boolean {
        val lookup = mapOf('0' to '0', '1' to '1', '6' to '9', '8' to '8', '9' to '6')
        val s = N.toString()
        for (c in s) {
            if (c !in lookup) {
                return false
            }
        }
        for (i in 0 until (s.length + 1) / 2) {
            if (s[i] != lookup[s[s.length - 1 - i]]) {
                return true
            }
        }
        return false
    }
}
