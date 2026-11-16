package rearrangearraytomaximizeprefixscore
// Time:  O(nlogn)
// Space: O(1)
class Solution {
    fun maxScore(nums: IntArray): Int {
        nums.sortDescending()
        var i = 0
        var current = 0L
        while (i < nums.size) {
            current += nums[i]
            if (current <= 0) {
                break
            }
            i++
        }
        return i
    }
}
