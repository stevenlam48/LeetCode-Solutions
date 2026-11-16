package reachendofarraywithmaxscore
// Time:  O(n)
// Space: O(1)
class Solution {
    fun findMaximumScore(nums: IntArray): Long {
        var result = 0L
        var mx = 0
        for (x in nums) {
            result += mx
            mx = maxOf(mx, x)
        }
        return result
    }
}
