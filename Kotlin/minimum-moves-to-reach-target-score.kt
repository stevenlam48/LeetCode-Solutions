package minimummovestoreachtargetscore

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun minMoves(target: Int, maxDoubles: Int): Int {
        var result = 0
        var remaining = target
        var doubles = maxDoubles
        while (remaining > 1 && doubles != 0) {
            result += 1 + remaining % 2
            remaining /= 2
            --doubles
        }
        return result + (remaining - 1)
    }
}
