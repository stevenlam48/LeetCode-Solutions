package bitwiseandofnumbersrange

// Time:  O(1)
// Space: O(1)
class Solution {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var right = n
        while (m < right) {
            right = right and (right - 1)
        }
        return right
    }
}
