package maximumandminimumsumsofatmostsizeksubarrays

// Time:  O(n)
// Space: O(k)

class Solution {
    fun minMaxSubarraySum(nums: IntArray, k: Int): Long {
        fun count(check: (Int, Int) -> Boolean): Long {
            var result = 0L
            var total = 0L
            val dq = ArrayDeque<Int>()
            for (right in nums.indices) {
                while (dq.isNotEmpty() && !check(nums[dq.last()], nums[right])) {
                    val i = dq.removeLast()
                    val cnt = i - (if (dq.isNotEmpty()) dq.last() + 1 else maxOf(right - k + 1, 0)) + 1
                    total -= cnt.toLong() * nums[i]
                }
                val cnt = right - (if (dq.isNotEmpty()) dq.last() + 1 else maxOf(right - k + 1, 0)) + 1
                dq.addLast(right)
                total += cnt.toLong() * nums[right]
                result += total
                if (right >= k - 1) {
                    total -= nums[dq.first()]
                    if (dq.first() == right - (k - 1)) {
                        dq.removeFirst()
                    }
                }
            }
            return result
        }
        return count { a, b -> a < b } + count { a, b -> a > b }
    }
}
