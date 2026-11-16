package minimumadjacentswapstoalternateparity

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minSwaps(nums: IntArray): Int {
        fun count(j0: Int): Int {
            var j = j0
            var result = 0
            for (i in nums.indices) {
                if (nums[i] % 2 != 0) {
                    result += Math.abs(j - i)
                    j += 2
                }
            }
            return result
        }
        val cnt = nums.count { it % 2 != 0 }
        if (cnt == nums.size - cnt) {
            return minOf(count(0), count(1))
        }
        if (cnt == (nums.size - cnt) + 1) {
            return count(0)
        }
        if (cnt + 1 == nums.size - cnt) {
            return count(1)
        }
        return -1
    }
}
