package setmismatch

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        var xXorY = 0
        for (i in nums.indices) {
            xXorY = xXorY xor nums[i] xor (i + 1)
        }
        val bit = xXorY and (xXorY - 1).inv()
        val result = IntArray(2)
        for (i in nums.indices) {
            val numBucket = if ((nums[i] and bit) != 0) 1 else 0
            val indexBucket = if (((i + 1) and bit) != 0) 1 else 0
            result[numBucket] = result[numBucket] xor nums[i]
            result[indexBucket] = result[indexBucket] xor (i + 1)
        }
        if (!nums.contains(result[0])) {
            val temp = result[0]
            result[0] = result[1]
            result[1] = temp
        }
        return result
    }
}
