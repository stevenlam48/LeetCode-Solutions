package sumofsortableintegers

// Time:  O(nlog(logn))
// Space: O(n)

class Solution {
    fun sortableIntegers(nums: IntArray): Int {
        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = maxOf(prefix[i], nums[i])
        }
        val suffix = IntArray(nums.size + 1) { Int.MAX_VALUE }
        for (i in nums.indices.reversed()) {
            suffix[i] = minOf(suffix[i + 1], nums[i])
        }
        val prefix2 = IntArray(nums.size)
        for (i in 0 until nums.size - 1) {
            prefix2[i + 1] = prefix2[i] + if (nums[i] > nums[i + 1]) 1 else 0
        }

        fun check(k: Int): Boolean {
            if (nums.size % k != 0) {
                return false
            }
            for (i in nums.indices step k) {
                if (!(prefix[i] <= suffix[i] &&
                        prefix2[i + k - 1] - prefix2[i] +
                        (if (nums[i + k - 1] > nums[i]) 1 else 0) <= 1)
                ) {
                    return false
                }
            }
            return true
        }

        var result = 0
        for (k in 1..nums.size) {
            if (check(k)) {
                result += k
            }
        }
        return result
    }
}
