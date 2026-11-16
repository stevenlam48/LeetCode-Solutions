package videostitching
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun videoStitching(clips: Array<IntArray>, T: Int): Int {
        if (T == 0) {
            return 0
        }
        var result = 1
        var currReachable = 0
        var reachable = 0
        clips.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        for (clip in clips) {
            val left = clip[0]
            val right = clip[1]
            if (left > reachable) {
                break
            } else if (left > currReachable) {
                currReachable = reachable
                ++result
            }
            reachable = maxOf(reachable, right)
            if (reachable >= T) {
                return result
            }
        }
        return -1
    }
}
