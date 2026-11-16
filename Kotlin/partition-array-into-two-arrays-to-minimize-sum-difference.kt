package partitionarrayintotwoarraystominimizesumdifference

// Time:  O(n * 2^n)
// Space: O(2^n)

class Solution {
    fun minimumDifference(nums: IntArray): Int {
        val left = ArrayList<Int>()
        val right = ArrayList<Int>()
        for (i in nums.indices) {
            if (i < nums.size / 2) {
                left.add(nums[i])
            } else {
                right.add(nums[i])
            }
        }
        val total1 = left.sum()
        val total2 = right.sum()
        val bound = 1 shl left.size
        val sums = HashMap<Int, MutableList<Int>>()
        for (mask in 0 until bound) {
            var total = 0
            var bit = 1
            for (x in left) {
                if ((mask and bit) != 0) {
                    total += x
                }
                bit = bit shl 1
            }
            sums.getOrPut(Integer.bitCount(mask)) { mutableListOf() }.add(2 * total - total1)
        }
        for (v in sums.values) {
            v.sort()
        }
        var result = Int.MAX_VALUE
        for (mask in 0 until bound) {
            var total = 0
            var bit = 1
            for (x in right) {
                if ((mask and bit) != 0) {
                    total += x
                }
                bit = bit shl 1
            }
            val k = right.size - Integer.bitCount(mask)
            val diff = 2 * total - total2
            val list = sums[k] ?: continue
            val pos = list.binarySearch(-diff)
            val insertion = if (pos >= 0) pos else -pos - 1
            if (insertion < list.size) {
                result = minOf(result, kotlin.math.abs(list[insertion] + diff))
            }
            if (insertion > 0) {
                result = minOf(result, kotlin.math.abs(list[insertion - 1] + diff))
            }
        }
        return result
    }
}
