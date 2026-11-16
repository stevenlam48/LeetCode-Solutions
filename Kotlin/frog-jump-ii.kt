package frogjumpii

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun maxJump(stones: IntArray): Int {
        if (stones.size == 2) {
            return stones[1] - stones[0]
        }
        var result = 0
        var i = 0
        while (i + 2 < stones.size) {
            result = maxOf(result, stones[i + 2] - stones[i])
            ++i
        }
        return result
    }
}
