package minimizestringlength
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimizedStringLength(s: String): Int {
        return s.toHashSet().size
    }
}
