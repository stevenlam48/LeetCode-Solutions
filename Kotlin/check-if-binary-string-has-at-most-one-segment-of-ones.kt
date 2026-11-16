package checkifbinarystringhasatmostonesegmentofones

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkOnesSegment(s: String): Boolean {
        return !s.contains("01")
    }
}
