package maximumnumberofvisiblepoints

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun visiblePoints(points: Array<IntArray>, angle: Int, location: IntArray): Int {
        val pi = Math.PI
        val arr = ArrayList<Double>()
        var extra = 0
        for (p in points) {
            if (p[0] == location[0] && p[1] == location[1]) {
                ++extra
                continue
            }
            arr.add(Math.atan2((p[1] - location[1]).toDouble(), (p[0] - location[0]).toDouble()))
        }
        arr.sort()
        val n = arr.size
        for (i in 0 until n) {
            arr.add(arr[i] + 2.0 * pi)
        }
        val d = 2.0 * pi * (angle / 360.0)
        var result = 0
        var left = 0
        for (right in arr.indices) {
            while (arr[right] - arr[left] > d) {
                ++left
            }
            result = maxOf(result, right - left + 1)
        }
        return result + extra
    }
}
