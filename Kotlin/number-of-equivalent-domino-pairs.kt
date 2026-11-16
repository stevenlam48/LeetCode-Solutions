package numberofequivalentdominopairs

// Time:  O(n)
// Space: O(n)

class Solution {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        val count = HashMap<Pair<Int, Int>, Int>()
        for (domino in dominoes) {
            val key = Pair(minOf(domino[0], domino[1]), maxOf(domino[0], domino[1]))
            count[key] = (count[key] ?: 0) + 1
        }
        var result = 0
        for (v in count.values) {
            result += v * (v - 1) / 2
        }
        return result
    }
}
