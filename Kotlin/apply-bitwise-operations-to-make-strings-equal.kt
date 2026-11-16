package applybitwiseoperationstomakestringsequal

// Time:  O(n)
// Space: O(1)

class Solution {
    fun makeStringsEqual(s: String, target: String): Boolean {
        return s.contains('1') == target.contains('1')
    }
}
