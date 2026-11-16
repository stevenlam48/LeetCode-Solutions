package faircandyswap

// Time:  O(m + n)
// Space: O(m + n)

class Solution {
    fun fairCandySwap(A: IntArray, B: IntArray): IntArray {
        val diff = (A.sum() - B.sum()) / 2
        val setA = A.toHashSet()
        for (b in B) {
            if (b + diff in setA) {
                return intArrayOf(b + diff, b)
            }
        }
        return intArrayOf()
    }
}
