package nextgreaterelementi
// Time:  O(m + n)
// Space: O(m + n)

class Solution {
    fun nextGreaterElement(findNums: IntArray, nums: IntArray): IntArray {
        val stk = mutableListOf<Int>()
        val lookup = HashMap<Int, Int>()
        for (num in nums) {
            while (stk.isNotEmpty() && num > stk.last()) {
                lookup[stk.removeAt(stk.lastIndex)] = num
            }
            stk.add(num)
        }
        while (stk.isNotEmpty()) {
            lookup[stk.removeAt(stk.lastIndex)] = -1
        }
        val result = mutableListOf<Int>()
        for (num in findNums) {
            result.add(lookup[num]!!)
        }
        return result.toIntArray()
    }
}
