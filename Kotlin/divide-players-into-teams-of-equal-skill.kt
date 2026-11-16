package divideplayersintoteamsofequalskill

// Time:  O(n)
// Space: O(n)

// freq table
class Solution {
    fun dividePlayers(skill: IntArray): Long {
        val target = skill.sumOf { it.toLong() } / (skill.size / 2)
        val cnt = HashMap<Long, Long>()
        for (s in skill) {
            cnt[s.toLong()] = (cnt[s.toLong()] ?: 0L) + 1
        }
        var result = 0L
        for ((k, v) in cnt) {
            val other = target - k
            if (!cnt.containsKey(other) || cnt[other] != cnt[k]) {
                return -1
            }
            result += k * other * v
        }
        return result / 2
    }
}
