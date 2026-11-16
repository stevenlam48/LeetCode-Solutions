package findplayerswithzerooronelosses

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findWinners(matches: Array<IntArray>): Array<IntArray> {
        val lose = HashMap<Int, Int>()
        val playersSet = HashSet<Int>()
        for (x in matches) {
            lose[x[1]] = (lose[x[1]] ?: 0) + 1
            playersSet.add(x[0])
            playersSet.add(x[1])
        }
        val players = playersSet.sorted()
        val result = Array(2) { mutableListOf<Int>() }
        for (x in players) {
            for (i in 0 until 2) {
                if ((lose[x] ?: 0) == i) {
                    result[i].add(x)
                }
            }
        }
        return arrayOf(result[0].toIntArray(), result[1].toIntArray())
    }
}
