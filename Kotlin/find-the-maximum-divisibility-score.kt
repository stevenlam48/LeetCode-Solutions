package findthemaximumdivisibilityscore
// Time:  O(n * d)
// Space: O(1)

class Solution {
    fun maxDivScore(nums: IntArray, divisors: IntArray): Int {
        var maximumScore = -1
        var result = -1
        for (d in divisors) {
            var curr = 0
            for (x in nums) {
                if (x % d == 0) {
                    ++curr
                }
            }
            if (curr > maximumScore || curr == maximumScore && d < result) {
                maximumScore = curr
                result = d
            }
        }
        return result
    }
}
