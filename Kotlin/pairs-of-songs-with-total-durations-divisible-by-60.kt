package pairsofsongswithtotaldurationsdivisibleby60
// Time:  O(n)
// Space: O(1)

class Solution {
    fun numPairsDivisibleBy60(time: IntArray): Int {
        var result = 0
        val counter = IntArray(60)
        for (t in time) {
            result += counter[(60 - t % 60) % 60]
            counter[t % 60]++
        }
        return result
    }
}
