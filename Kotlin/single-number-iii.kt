package singlenumberiii

// Time:  O(n)
// Space: O(1)
class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        var xXorY = 0
        for (i in nums) xXorY = xXorY xor i
        val bit = xXorY and -xXorY
        val result = IntArray(2)
        for (i in nums) {
            val index = if (i and bit != 0) 1 else 0
            result[index] = result[index] xor i
        }
        return result
    }
}
