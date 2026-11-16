package longestuncommonsubsequencei

// Time:  O(min(a, b))
// Space: O(1)

class Solution {
    fun findLUSlength(a: String, b: String): Int {
        if (a == b) {
            return -1
        }
        return maxOf(a.length, b.length)
    }
}
