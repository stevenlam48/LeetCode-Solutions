package stonegameix

// Time:  O(n)
// Space: O(1)

class Solution {
    fun stoneGameIX(stones: IntArray): Boolean {
        val count = IntArray(3)
        for (x in stones) {
            ++count[x % 3]
        }
        if (count[0] % 2 == 0) {
            return count[1] != 0 && count[2] != 0
        }
        return Math.abs(count[1] - count[2]) >= 3
    }
}
