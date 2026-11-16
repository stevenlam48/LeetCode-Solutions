package findthemedianoftheuniquenessarray

// Time:  O(nlogn)
// Space: O(n)

// binary search, two pointers, sliding window
class Solution {
    fun medianOfUniquenessArray(nums: IntArray): Int {
        fun binarySearch(left0: Int, right0: Int, check: (Int) -> Boolean): Int {
            var left = left0
            var right = right0
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (check(mid)) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return left
        }

        val total = (nums.size + 1L) * nums.size / 2
        return binarySearch(1, nums.toHashSet().size) { k ->
            var result = 0L
            val cnt = HashMap<Int, Int>()
            var left = 0
            for (right in nums.indices) {
                cnt[nums[right]] = (cnt[nums[right]] ?: 0) + 1
                while (cnt.size == k + 1) {
                    val c = cnt[nums[left]]!! - 1
                    if (c == 0) {
                        cnt.remove(nums[left])
                    } else {
                        cnt[nums[left]] = c
                    }
                    ++left
                }
                result += right - left + 1
            }
            result >= total - result
        }
    }
}
