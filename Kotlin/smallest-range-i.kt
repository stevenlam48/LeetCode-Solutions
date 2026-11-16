package smallestrangei
// Time:  O(n)
// Space: O(1)

class Solution {
    fun smallestRangeI(A: IntArray, K: Int): Int {
        return maxOf(0, A.max() - A.min() - 2 * K)
    }
}
