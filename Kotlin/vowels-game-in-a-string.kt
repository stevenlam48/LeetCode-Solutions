package vowelsgameinastring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun doesAliceWin(s: String): Boolean {
        return s.any { it in "aeiou" }
    }
}
