package minimumdeletioncosttoavoidrepeatingletters

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minCost(s: String, cost: IntArray): Int {
        var result = 0
        var accu = 0
        var maxCost = 0
        for (i in s.indices) {
            if (i > 0 && s[i] != s[i - 1]) {
                result += accu - maxCost
                accu = 0
                maxCost = 0
            }
            accu += cost[i]
            maxCost = maxOf(maxCost, cost[i])
        }
        result += accu - maxCost
        return result
    }
}
