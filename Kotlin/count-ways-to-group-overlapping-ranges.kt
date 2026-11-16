package countwaystogroupoverlappingranges

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun countWays(ranges: Array<IntArray>): Int {
        val mod = 1_000_000_007

        ranges.sortWith(compareBy<IntArray>({ it[0] }, { it[1] }))
        var result = 1
        var curr = Int.MIN_VALUE
        for (r in ranges) {
            if (r[0] > curr) {
                result = (result * 2) % mod
            }
            curr = maxOf(curr, r[1])
        }
        return result
    }
}
