package maximumlengthofpairchain

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortWith(compareBy { it[1] })
        var count = 0
        var i = 0
        for (j in pairs.indices) {
            if (j == 0 || pairs[i][1] < pairs[j][0]) {
                count++
                i = j
            }
        }
        return count
    }
}
