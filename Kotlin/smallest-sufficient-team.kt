package smallestsufficientteam

// Time:  O(m * 2^n), n is the number of skills
//                    m is the number of people
// Space: O(2^n)

class Solution {
    fun smallestSufficientTeam(reqSkills: List<String>, people: List<List<String>>): List<Int> {
        val lookup = HashMap<String, Int>()
        for (i in reqSkills.indices) {
            lookup[reqSkills[i]] = i
        }
        val dp = HashMap<Int, List<Int>>()
        dp[0] = emptyList()
        for (i in people.indices) {
            var hisSkillSet = 0
            for (skill in people[i]) {
                lookup[skill]?.let { hisSkillSet = hisSkillSet or (1 shl it) }
            }
            val tmp = HashMap(dp)
            for ((skillSet, team) in tmp) {
                val withHimSet = skillSet or hisSkillSet
                if (withHimSet == skillSet) {
                    continue
                }
                if (!dp.containsKey(withHimSet) || dp.getValue(withHimSet).size > team.size + 1) {
                    dp[withHimSet] = team + i
                }
            }
        }
        return dp[(1 shl reqSkills.size) - 1] ?: emptyList()
    }
}
