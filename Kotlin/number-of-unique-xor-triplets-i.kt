package numberofuniquexortripletsi

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun uniqueXorTriplets(nums: IntArray): Int {
        val n = nums.size
        val bitLength = if (n == 0) 0 else 32 - Integer.numberOfLeadingZeros(n)
        return if (n >= 3) 1 shl bitLength else n
    }
}
