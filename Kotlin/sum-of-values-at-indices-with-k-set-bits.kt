package sumofvaluesatindiceswithksetbits

// Time:  O(C(ceil(log2(n)), k))
// Space: O(1)

// bit manipulation, hakmem-175
class Solution {
    fun sumIndicesWithKSetBits(nums: IntArray, k: Int): Int {
        val nextPopcount = { n0: Int ->
            val n = n0.toLong() and 0xFFFFFFFFL
            val lowestBit = n and (-n)
            val leftBits = n + lowestBit
            val changedBits = n xor leftBits
            val rightBits = (changedBits / lowestBit) shr 2
            (leftBits or rightBits).toInt()
        }

        var result = 0
        var i = (1 shl k) - 1
        while (i < nums.size) {
            result += nums[i]
            if (i == 0) {
                break
            }
            i = nextPopcount(i)
        }
        return result
    }
}
