package countsubarrayswithdistantsums

// Time:  O(nlogn)
// Space: O(n)

// prefix sum, bit
class Solution {
    fun distantSubarrays(nums: IntArray, goal: Int, k: Int): Long {
        if (k == 0) {
            return (nums.size + 1).toLong() * nums.size / 2
        }
        val prefix = LongArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        val vals = prefix.sorted().distinct().toLongArray()
        val valToIdx = HashMap<Long, Int>()
        for (i in vals.indices) {
            valToIdx[vals[i]] = i
        }
        val bit = BIT(vals.size)
        bit.add(valToIdx[0L]!!, 1)
        var result = 0L
        for (i in nums.indices) {
            result += bit.query(upperBound(vals, prefix[i + 1] - (goal + k)) - 1)
            result += (i + 1) - bit.query(lowerBound(vals, prefix[i + 1] - (goal - k)) - 1)
            bit.add(valToIdx[prefix[i + 1]]!!, 1)
        }
        return result
    }

    private fun lowerBound(a: LongArray, target: Long): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (a[mid] < target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    private fun upperBound(a: LongArray, target: Long): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (a[mid] <= target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    private class BIT(n: Int) {
        private val bit = IntArray(n + 1)

        fun add(i0: Int, v: Int) {
            var i = i0 + 1
            while (i < bit.size) {
                bit[i] += v
                i += i and -i
            }
        }

        fun query(i0: Int): Int {
            var i = i0 + 1
            var total = 0
            while (i > 0) {
                total += bit[i]
                i -= i and -i
            }
            return total
        }
    }
}
