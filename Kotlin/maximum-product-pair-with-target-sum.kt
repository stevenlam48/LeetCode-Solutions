package maximumproductpairwithtargetsum

// Time:  O(n)
// Space: O(n)

// hash table
class Solution {
    fun maxProductPair(nums: IntArray, target: Int): IntArray {
        val result = intArrayOf(-1, -1)
        var mx = Int.MIN_VALUE
        val lookup = HashMap<Int, Int>()
        for (i in nums.indices) {
            val x = nums[i]
            val other = target - x
            if (lookup.containsKey(other) && x != other && x * other > mx) {
                mx = x * other
                result[0] = i
                result[1] = lookup[other]!!
                if (x < other) {
                    val tmp = result[0]
                    result[0] = result[1]
                    result[1] = tmp
                }
            }
            lookup[x] = i
        }
        return result
    }
}
