package nextgreaterelementiv
// Time:  O(n)
// Space: O(n)

class Solution {
    fun secondGreaterElement(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { -1 }
        val stk1 = mutableListOf<Int>()
        val stk2 = mutableListOf<Int>()
        for (i in nums.indices) {
            while (stk2.isNotEmpty() && nums[stk2.last()] < nums[i]) {
                result[stk2.removeAt(stk2.lastIndex)] = nums[i]
            }
            val tmp = mutableListOf<Int>()
            while (stk1.isNotEmpty() && nums[stk1.last()] < nums[i]) {
                tmp.add(stk1.removeAt(stk1.lastIndex))
            }
            stk1.add(i)
            for (j in tmp.size - 1 downTo 0) {
                stk2.add(tmp[j])
            }
        }
        return result
    }
}
