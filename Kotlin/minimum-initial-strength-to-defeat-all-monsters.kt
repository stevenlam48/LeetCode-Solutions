package minimuminitialstrengthtodefeatallmonsters
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minInitialStrength(monsters: IntArray, boosts: Array<IntArray>): Long {
        val diff = LongArray(monsters.size)
        for (b in boosts) {
            diff[b[1]] += b[2]
            if (b[0] - 1 >= 0) {
                diff[b[0] - 1] -= b[2]
            }
        }
        var result = 0L
        var bonus = 0L
        for (i in monsters.indices.reversed()) {
            bonus += diff[i]
            result += if (result != 0L) monsters[i].toLong() else maxOf(monsters[i] - bonus, 0L)
        }
        return result
    }
}
