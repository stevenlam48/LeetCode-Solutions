package subarraywithelementsgreaterthanvaryingthreshold

// Time:  O(n)
// Space: O(n)

// mono stack
class Solution {
    fun validSubarraySize(nums: IntArray, threshold: Int): Int {
        val stk = ArrayDeque<Int>()
        stk.addLast(-1)
        for (i in 0..nums.size) {
            while (stk.last() != -1 && (i == nums.size || nums[stk.last()] >= nums[i])) {
                val j = stk.removeLast()
                if (nums[j].toLong() * ((i - 1) - stk.last()) > threshold) {
                    return (i - 1) - stk.last()
                }
            }
            stk.addLast(i)
        }
        return -1
    }
}
