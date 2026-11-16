package eliminatemaximumnumberofmonsters

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        for (i in dist.indices) {
            dist[i] = (dist[i] - 1) / speed[i]
        }
        dist.sort()
        var result = 0
        while (result < dist.size && result <= dist[result]) {
            ++result
        }
        return result
    }
}
