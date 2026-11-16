package checkifgridcanbecutintosections

// Time:  O(nlogn)
// Space: O(1)
class Solution {
    fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
        fun check(idx: Int): Boolean {
            var cnt = 0
            var curr = rectangles[0][idx + 2]
            for (x in rectangles) {
                if (curr <= x[idx]) {
                    ++cnt
                }
                curr = maxOf(curr, x[idx + 2])
            }
            return cnt >= 2
        }

        for (idx in 0 until 2) {
            rectangles.sortWith(compareBy { it[idx] })
            if (check(idx)) {
                return true
            }
        }
        return false
    }
}
