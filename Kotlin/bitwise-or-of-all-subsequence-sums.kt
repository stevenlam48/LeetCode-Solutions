package bitwiseorofallsubsequencesums

// Time:  O(n)
// Space: O(1)

// bit manipulation
class Solution {
    fun subsequenceSumOr(nums: IntArray): Long {
        var result = 0L
        var prefix = 0L
        for (x in nums) {
            prefix += x
            result = result or (x.toLong() or prefix)
        }
        return result
    }
}
