package longestsubarraywithrestrictedpairsums
// Time:  O(n * r)
// Space: O(r)

class Solution {
    fun maxSubarray(nums: IntArray): Int {
        val counts = IntArray(nums.max() + 1)
        fun count(x: Int): Long {
            var result = 0L
            for (y in 1..x / 2) {
                result += if (y != x - y) {
                    counts[y].toLong() * counts[x - y]
                } else {
                    counts[y].toLong() * (counts[y] - 1) / 2
                }
            }
            for (y in 1 until counts.size - x) {
                result += counts[y].toLong() * counts[x + y]
            }
            return result
        }

        var left = 0
        var total = 0L
        for (x in nums) {
            total += count(x)
            ++counts[x]
            if (total != 0L) {
                --counts[nums[left]]
                total -= count(nums[left++])
            }
        }
        return nums.size - left
    }
}
