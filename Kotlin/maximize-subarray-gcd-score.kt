package maximizesubarraygcdscore
// Time:  O(nlogn * logr), r = max(nums)
// Space: O(n + logr)

class Solution {
    fun maxGCDScore(nums: IntArray, k: Int): Long {
        val inf = Int.MAX_VALUE
        val lookup = IntArray(nums.size)
        for (i in nums.indices) {
            while ((nums[i] and 1) == 0) {
                nums[i] = nums[i] shr 1
                ++lookup[i]
            }
        }
        val maxE = lookup.max()
        val lookup2 = Array(maxE + 1) { mutableListOf<Int>() }
        for (i in lookup.indices) {
            lookup2[lookup[i]].add(i)
        }
        var result = 0L
        var dp = HashMap<Int, HashMap<Int, IntArray>>()
        for (i in nums.indices) {
            val newDp = HashMap<Int, HashMap<Int, IntArray>>()
            newDp.getOrPut(nums[i]) { HashMap() }[lookup[i]] = intArrayOf(i, i)
            for ((g, eValues) in dp) {
                for ((e, v) in eValues) {
                    val ng = gcd(g, nums[i])
                    val ne = minOf(e, lookup[i])
                    val values = newDp.getOrPut(ng) { HashMap() }
                        .getOrPut(ne) { intArrayOf(inf, inf) }
                    values[0] = minOf(values[0], v[0])
                    val left = lowerBound(lookup2[ne], v[0])
                    val right = upperBound(lookup2[ne], i) - 1
                    values[1] = minOf(
                        values[1],
                        if (right - left + 1 <= k) v[0] else lookup2[ne][right - k] + 1
                    )
                }
            }
            dp = newDp
            for ((g, eValues) in dp) {
                for ((e, v) in eValues) {
                    result = maxOf(result, (g.toLong() * (i - v[0] + 1)) shl e)
                    result = maxOf(result, (g.toLong() * (i - v[1] + 1)) shl (e + 1))
                }
            }
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private fun lowerBound(values: List<Int>, target: Int): Int {
        var left = 0
        var right = values.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (values[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    private fun upperBound(values: List<Int>, target: Int): Int {
        var left = 0
        var right = values.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (values[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
