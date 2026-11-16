package kclosestpointstoorigin
// Time:  O(n) on average
// Space: O(1)

class Solution {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        fun dist(v: IntArray): Int = v[0] * v[0] + v[1] * v[1]
        points.sortWith(compareBy(::dist))
        return points.copyOfRange(0, K)
    }
}
