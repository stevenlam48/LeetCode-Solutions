package minimumnumbersoffunctioncallstomaketargetarray

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minOperations(nums: IntArray): Int {
        var result = 0
        var maxLen = 1
        for (num in nums) {
            result += Integer.bitCount(num)
            maxLen = maxOf(maxLen, bitLength(num))
        }
        return result + maxLen - 1
    }

    private fun bitLength(x: Int): Int {
        return if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 1
    }
}
