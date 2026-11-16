package rankteamsbyvotes
// Time:  O(m * (n + mlogm)), n is the number of votes
//                          , m is the length of vote
// Space: O(m^2)
class Solution {
    fun rankTeams(votes: List<String>): String {
        val count = HashMap<Char, IntArray>()
        for (team in votes[0]) {
            val ranks = IntArray(votes[0].length + 1)
            ranks[votes[0].length] = team.code
            count[team] = ranks
        }
        for (vote in votes) {
            for (i in vote.indices) {
                count[vote[i]]!![i]--
            }
        }
        val teams = votes[0].toMutableList()
        teams.sortWith { a, b ->
            var comparison = 0
            val countA = count[a]!!
            val countB = count[b]!!
            for (i in countA.indices) {
                if (countA[i] != countB[i]) {
                    comparison = countA[i] - countB[i]
                    break
                }
            }
            comparison
        }
        return teams.joinToString("")
    }
}
