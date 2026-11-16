package alldivisionswiththehighestscoreofabinaryarray

// Time:  O(n)
// Space: O(1)

// prefix sum
class Solution {
    fun maxScoreIndices(nums: IntArray): List<Int> {
        val total = nums.sum()
        val result = mutableListOf<Int>()
        var zeros = 0
        var mx = 0
        for (i in 0..nums.size) {
            zeros += if (i - 1 >= 0 && nums[i - 1] == 0) 1 else 0
            if (zeros + (total - (i - zeros)) > mx) {
                mx = zeros + (total - (i - zeros))
                result.clear()
            }
            if (zeros + (total - (i - zeros)) == mx) {
                result.add(i)
            }
        }
        return result
    }
}
