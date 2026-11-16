package movingstonesuntilconsecutiveii

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun numMovesStonesII(stones: IntArray): IntArray {
        stones.sort()
        var left = 0
        var minMoves = Int.MAX_VALUE
        val n = stones.size
        val maxMoves = maxOf(stones[n - 1] - stones[1], stones[n - 2] - stones[0]) - (n - 2)
        for (right in stones.indices) {
            while (stones[right] - stones[left] + 1 > n) {
                ++left
            }
            if (n - (right - left + 1) == 1 && stones[right] - stones[left] + 1 == n - 1) {
                minMoves = minOf(minMoves, 2)
            } else {
                minMoves = minOf(minMoves, n - (right - left + 1))
            }
        }
        return intArrayOf(minMoves, maxMoves)
    }
}
