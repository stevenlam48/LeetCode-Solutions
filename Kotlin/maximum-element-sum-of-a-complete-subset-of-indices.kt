package maximumelementsumofacompletesubsetofindices

// Time:  O(n * (1 + 1/4 + 1/9 + ...)) = O(pi^2 / 6 * n) = O(n), see https://en.wikipedia.org/wiki/Basel_problem
// Space: O(1)

// number theory, basel problem
class Solution {
    fun maximumSum(nums: IntArray): Long {
        var result = 0L
        for (i in 1..nums.size) {
            var curr = 0L
            var x = 1
            while (i.toLong() * x * x - 1 < nums.size) {
                curr += nums[i * x * x - 1]
                ++x
            }
            result = maxOf(result, curr)
        }
        return result
    }
}
