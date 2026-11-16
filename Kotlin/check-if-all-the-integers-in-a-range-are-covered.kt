package checkifalltheintegersinarangearecovered

// Time:  O(n + r)
// Space: O(r)

class Solution {
    fun isCovered(ranges: Array<IntArray>, left: Int, right: Int): Boolean {
        val RANGE_SIZE = 50

        val interval = IntArray(RANGE_SIZE + 1)
        for (r in ranges) {
            ++interval[r[0] - 1]
            --interval[r[1]]
        }
        var cnt = 0
        for (i in 0..right - 1) {
            cnt += interval[i]
            if (i >= left - 1 && cnt == 0) {
                return false
            }
        }
        return true
    }
}
