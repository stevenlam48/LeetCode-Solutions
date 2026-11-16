package findtheminimumamountoftimetobrewpotions

// Time:  O(n * m)
// Space: O(1)

// prefix sum, greedy
class Solution {
    fun minTime(skill: IntArray, mana: IntArray): Long {
        var result = 0L
        for (i in 1 until mana.size) {
            var prefix = 0L
            var mx = 0L
            for (x in skill) {
                prefix += x
                mx = maxOf(mx, mana[i - 1].toLong() * prefix - mana[i].toLong() * (prefix - x))
            }
            result += mx
        }
        result += mana.last().toLong() * skill.sumOf { it.toLong() }
        return result
    }
}
