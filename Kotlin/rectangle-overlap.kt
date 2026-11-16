package rectangleoverlap

// Time:  O(1)
// Space: O(1)

class Solution {
    fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        return intersect(rec1[0], rec1[2], rec2[0], rec2[2]) &&
                intersect(rec1[1], rec1[3], rec2[1], rec2[3])
    }

    private fun intersect(pLeft: Int, pRight: Int, qLeft: Int, qRight: Int): Boolean {
        return maxOf(pLeft, qLeft) < minOf(pRight, qRight)
    }
}
