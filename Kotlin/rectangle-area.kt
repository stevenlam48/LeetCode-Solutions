package rectanglearea

// Time:  O(1)
// Space: O(1)

class Solution {
    fun computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
        val area1 = (D.toLong() - B) * (C.toLong() - A)
        val area2 = (G.toLong() - E) * (H.toLong() - F)
        val overlapW = maxOf(0, minOf(C, G) - maxOf(A, E)).toLong()
        val overlapH = maxOf(0, minOf(D, H) - maxOf(B, F)).toLong()
        return (area1 + area2 - overlapW * overlapH).toInt()
    }
}
