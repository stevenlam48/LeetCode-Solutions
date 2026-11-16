package frogjump

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun canCross(stones: IntArray): Boolean {
        if (stones[1] != 1) {
            return false
        }

        val lastJumpUnits = HashMap<Int, HashSet<Int>>()
        for (s in stones) {
            lastJumpUnits[s] = HashSet()
        }
        lastJumpUnits[1]!!.add(1)

        for (i in 0 until stones.size - 1) {
            for (j in lastJumpUnits[stones[i]]!!) {
                for (k in intArrayOf(j - 1, j, j + 1)) {
                    if (k > 0 && lastJumpUnits.containsKey(stones[i] + k)) {
                        lastJumpUnits[stones[i] + k]!!.add(k)
                    }
                }
            }
        }

        return lastJumpUnits[stones.last()]!!.isNotEmpty()
    }
}
