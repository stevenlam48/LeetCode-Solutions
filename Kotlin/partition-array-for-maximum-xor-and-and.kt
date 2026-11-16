package partitionarrayformaximumxorandand

// Time:  O(nlogr * 2^n)
// Space: O(2^n)

// bitmasks, greedy
class Solution {
    fun maximizeXorAndXor(nums: IntArray): Long {
        fun bitLength(x: Int): Int = if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 0

        val l = bitLength(nums.max())
        val n = nums.size
        val fullMask = (1 shl n) - 1
        val andArr = IntArray(1 shl n)
        val xorArr = IntArray(1 shl n)
        for (mask in 1 until (1 shl n)) {
            val lb = mask and -mask
            val i = Integer.numberOfTrailingZeros(lb)
            andArr[mask] = if ((mask xor lb) != 0) andArr[mask xor lb] and nums[i] else nums[i]
            xorArr[mask] = xorArr[mask xor lb] xor nums[i]
        }
        var result = 0L
        val base = IntArray(l)
        for (mask in 1 until (1 shl n)) {
            val totalAnd = andArr[mask]
            val totalXor = xorArr[fullMask xor mask]
            base.fill(0)
            var remain = fullMask xor mask
            while (remain != 0) {
                val i = Integer.numberOfTrailingZeros(remain)
                var x = nums[i] and totalXor.inv()
                for (j in l - 1 downTo 0) {
                    if ((x and (1 shl j)) == 0) {
                        continue
                    }
                    if (base[j] == 0) {
                        base[j] = x
                        break
                    }
                    x = x xor base[j]
                }
                remain = remain and (remain - 1)
            }
            var maxXor = 0
            for (j in l - 1 downTo 0) {
                if ((maxXor xor base[j]) > maxXor) {
                    maxXor = maxXor xor base[j]
                }
            }
            result = maxOf(result, (totalAnd + totalXor).toLong() + 2L * maxXor)
        }
        return result
    }
}
