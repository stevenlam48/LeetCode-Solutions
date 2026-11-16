package minimumdeletionstomakestringbalanced
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumDeletions(s: String): Int {
        var result = 0
        var bCount = 0
        for (c in s) {
            if (c == 'b') {
                ++bCount
            } else if (bCount != 0) {
                --bCount
                ++result
            }
        }
        return result
    }
}
