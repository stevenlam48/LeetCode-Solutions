package minimumsidewayjumps

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minSideJumps(obstacles: IntArray): Int {
        var result = 0
        val lanes = hashSetOf(2)
        for (i in 0 until obstacles.size - 1) {
            lanes.remove(obstacles[i + 1])
            if (lanes.isNotEmpty()) {
                continue
            }
            ++result
            for (j in 1..3) {
                if (j != obstacles[i] && j != obstacles[i + 1]) {
                    lanes.add(j)
                }
            }
        }
        return result
    }
}
