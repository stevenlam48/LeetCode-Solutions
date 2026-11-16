package elementsinarrayafterremovingandreplacingelements

// Time:  O(n)
// Space: O(1)
class Solution {
    fun elementInNums(nums: IntArray, queries: Array<IntArray>): IntArray {
        val result = IntArray(queries.size)
        for ((index, q) in queries.withIndex()) {
            val t = q[0] % (2 * nums.size)
            val i = q[1]
            if (t + i < nums.size) {
                result[index] = nums[t + i]
            } else if (i < t - nums.size) {
                result[index] = nums[i]
            } else {
                result[index] = -1
            }
        }
        return result
    }
}
