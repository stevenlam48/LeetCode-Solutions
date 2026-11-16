package productofarrayexceptself

// Time:  O(n)
// Space: O(1)

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.isEmpty()) {
            return IntArray(0)
        }
        val leftProduct = IntArray(nums.size)
        leftProduct[0] = 1
        for (i in 1 until nums.size) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1]
        }
        var rightProduct = 1
        for (i in nums.size - 2 downTo 0) {
            rightProduct *= nums[i + 1]
            leftProduct[i] *= rightProduct
        }
        return leftProduct
    }
}
