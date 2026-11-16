package maximumpossiblenumberbybinaryconcatenation
// Time:  O(n * logr * logn)
// Space: O(nlogr)

class Solution {
    fun maxGoodNumber(nums: IntArray): Int {
        fun toBinary(x: Int): String {
            var value = x
            val result = StringBuilder()
            while (value != 0) {
                result.append(if (value and 1 != 0) '1' else '0')
                value = value shr 1
            }
            return result.reverse().toString()
        }

        val binaries = Array(nums.size) { toBinary(nums[it]) }
        binaries.sortWith(Comparator { a, b -> (b + a).compareTo(a + b) })
        return binaries.joinToString("").toInt(2)
    }
}
