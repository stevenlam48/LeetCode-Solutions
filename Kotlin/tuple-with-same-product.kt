package tuplewithsameproduct
// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun tupleSameProduct(nums: IntArray): Int {
        var result = 0
        val count = HashMap<Int, Int>()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val product = nums[i] * nums[j]
                result += count.getOrDefault(product, 0)
                count[product] = count.getOrDefault(product, 0) + 1
            }
        }
        return 8 * result
    }
}
