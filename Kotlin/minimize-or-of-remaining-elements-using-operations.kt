package minimizeorofremainingelementsusingoperations

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun minOrAfterOperations(nums: IntArray, k: Int): Int {
        fun bitLength(x: Int): Int {
            return if (x == 0) 0 else Int.SIZE_BITS - Integer.numberOfLeadingZeros(x)
        }

        var result = 0
        val length = bitLength(nums.max())
        val mask = (1 shl length) - 1
        var i = length - 1
        while (i >= 0) {
            result = result shl 1
            var curr = mask
            var count = 0
            for (x in nums) {
                curr = curr and (x shr i)
                if ((curr and result.inv()) != 0) {
                    ++count
                } else {
                    curr = mask
                }
            }
            if (count > k) {
                ++result
            }
            --i
        }
        return result
    }
}
