package smallestsubarraytosortineveryslidingwindow
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minSubarraySort(nums: IntArray, k: Int): IntArray {
        val n = nums.size

        fun count(values: IntArray): IntArray {
            val nxt = IntArray(n) { n }
            val stk = mutableListOf<Int>()
            for (i in n - 1 downTo 0) {
                while (stk.isNotEmpty() && values[stk.last()] < values[i]) {
                    stk.removeLast()
                }
                if (stk.isNotEmpty()) {
                    nxt[i] = stk.last()
                }
                stk.add(i)
            }
            val result = mutableListOf<Int>()
            var j = 0
            var left = -1
            for (i in 1 until n) {
                if (values[i] < values[i - 1]) {
                    left = i
                }
                if (i < k - 1) {
                    continue
                }
                j = maxOf(j, i - (k - 1))
                while (nxt[j] <= left) {
                    j = nxt[j]
                }
                result.add(maxOf(i - nxt[j] + 1, 0))
            }
            return result.toIntArray()
        }

        val result = IntArray(n - k + 1)
        if (k == 1) {
            return result
        }
        val right = count(nums)
        for (i in 0..(n - 1) / 2) {
            val opposite = n - 1 - i
            val temp = nums[i]
            nums[i] = -nums[opposite]
            nums[opposite] = -temp
        }
        val left = count(nums)
        for (i in result.indices) {
            result[i] = maxOf(k - left[((n - k + 1) - 1) - i] - right[i], 0)
        }
        return result
    }
}
