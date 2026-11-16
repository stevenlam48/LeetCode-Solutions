package checkifallasappearsbeforeallbs

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkString(s: String): Boolean {
        return !s.contains("ba")
    }
}
