package minimumoperationstomakearrayparityalternating

// Time:  O(n)
// Space: O(1)

class Solution {
    fun makeParityAlternating(nums: IntArray): IntArray {
        val posInf = Int.MAX_VALUE
        val negInf = Int.MIN_VALUE

        fun count(target: Int): IntArray {
            var cnt = 0
            var mn = posInf
            var mx = negInf
            for (i in nums.indices) {
                if ((nums[i] and 1) == ((i and 1) xor target)) {
                    mn = minOf(mn, nums[i])
                    mx = maxOf(mx, nums[i])
                } else {
                    ++cnt
                    mn = minOf(mn, nums[i] + 1)
                    mx = maxOf(mx, nums[i] - 1)
                }
            }
            return intArrayOf(
                cnt,
                if (nums.size == 1) 0 else if (nums.maxOrNull() == nums.minOrNull()) 1 else mx - mn
            )
        }

        val first = count(0)
        val second = count(1)
        return if (first[0] < second[0] ||
            (first[0] == second[0] && first[1] <= second[1])
        ) {
            first
        } else {
            second
        }
    }
}
