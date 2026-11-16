package sumofsubarrayranges

// Time:  O(n)
// Space: O(n)

class Solution {
    fun subArrayRanges(nums: IntArray): Long {
        var result = 0L
        val stk = ArrayList<Int>()
        for (i in 0..nums.size) {
            val x = if (i < nums.size) nums[i] else Int.MAX_VALUE
            while (stk.isNotEmpty() && nums[stk[stk.size - 1]] <= x) {
                val j = stk.removeAt(stk.size - 1).toLong()
                val k = if (stk.isNotEmpty()) stk[stk.size - 1].toLong() else -1L
                result += nums[j.toInt()] * (j - k) * (i - j)
            }
            stk.add(i)
        }
        stk.clear()
        for (i in 0..nums.size) {
            val x = if (i < nums.size) nums[i] else Int.MIN_VALUE
            while (stk.isNotEmpty() && nums[stk[stk.size - 1]] >= x) {
                val j = stk.removeAt(stk.size - 1).toLong()
                val k = if (stk.isNotEmpty()) stk[stk.size - 1].toLong() else -1L
                result -= nums[j.toInt()] * (j - k) * (i - j)
            }
            stk.add(i)
        }
        return result
    }
}
