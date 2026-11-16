package nextgreaterelementii
// Time:  O(n)
// Space: O(n)

class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        val stk = mutableListOf<Int>()
        if (nums.isEmpty()) {
            return result
        }
        for (i in 2 * nums.size - 1 downTo 0) {
            while (stk.isNotEmpty() && stk.last() <= nums[i % nums.size]) {
                stk.removeAt(stk.lastIndex)
            }
            result[i % nums.size] = if (stk.isEmpty()) -1 else stk.last()
            stk.add(nums[i % nums.size])
        }
        return result
    }
}
