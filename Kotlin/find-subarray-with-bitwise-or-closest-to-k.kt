package findsubarraywithbitwiseorclosesttok

// Time:  O(nlogr), r = max(nums)
// Space: O(logr)

// freq table, two pointers, sliding window, lc1521
class Solution {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        val count = BitCount(bitLength(nums.maxOrNull()!!))
        var result = Int.MAX_VALUE
        var left = 0
        var right = 0
        while (right < nums.size) {
            count += nums[right]
            while (left <= right) {
                val f = count.bitOr()
                result = minOf(result, Math.abs(f - k))
                if (f <= k) {
                    break
                }
                count -= nums[left]
                ++left
            }
            ++right
        }
        return result
    }

    private fun bitLength(x: Int): Int {
        return (if (x != 0) 31 - Integer.numberOfLeadingZeros(x) else -1) + 1
    }

    private class BitCount(n0: Int) {
        private var l_: Int = 0
        private val n_: Int = n0
        private val count_: IntArray = IntArray(n0)

        fun bitOr(): Int {
            var num = 0
            for (i in 0 until n_) {
                if (count_[i] != 0) {
                    num = num or (1 shl i)
                }
            }
            return num
        }

        operator fun plusAssign(num: Int) {
            ++l_
            for (i in 0 until n_) {
                if ((num and (1 shl i)) != 0) {
                    ++count_[i]
                }
            }
        }

        operator fun minusAssign(num: Int) {
            --l_
            for (i in 0 until n_) {
                if ((num and (1 shl i)) != 0) {
                    --count_[i]
                }
            }
        }
    }
}
