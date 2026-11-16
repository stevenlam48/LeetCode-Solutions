package replaceelementsinanarray
// Time:  O(n + m)
// Space: O(n)

class Solution {
    fun arrayChange(nums: IntArray, operations: Array<IntArray>): IntArray {
        val lookup = HashMap<Int, Int>()
        for (i in nums.indices) {
            lookup[nums[i]] = i
        }
        for (op in operations) {
            val i = lookup.remove(op[0])!!
            lookup[op[1]] = i
        }
        for ((x, i) in lookup) {
            nums[i] = x
        }
        return nums
    }
}
