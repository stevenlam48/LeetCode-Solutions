package stonegameviii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun stoneGameVIII(stones: IntArray): Int {
        for (i in 1 until stones.size) {
            stones[i] += stones[i - 1]
        }
        var curr = stones[stones.size - 1]
        for (k in stones.size - 2 downTo 1) {
            curr = maxOf(curr, stones[k] - curr)
        }
        return curr
    }
}
