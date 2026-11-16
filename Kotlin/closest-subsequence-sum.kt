package closestsubsequencesum

// Time:  O(n * 2^(n/2))
// Space: O(2^(n/2))


import kotlin.math.abs

class Solution {
    fun minAbsDifference(nums: IntArray, goal: Int): Int {
        var mx = 0
        var mn = 0
        for (x in nums) {
            if (x > 0) {
                mx += x
            } else if (x < 0) {
                mn += x
            }
        }
        if (goal > mx) {
            return goal - mx
        }
        if (goal < mn) {
            return mn - goal
        }
        var result = abs(goal)
        val sums1 = HashSet<Int>()
        sums1.add(0)
        for (i in 0 until nums.size / 2) {
            for (x in sums1.toList()) {
                if (!sums1.add(x + nums[i])) {
                    continue
                }
                result = minOf(result, abs(goal - x - nums[i]))
            }
        }
        val sortedSums1 = sums1.toIntArray()
        sortedSums1.sort()
        val sums2 = HashSet<Int>()
        sums2.add(0)
        for (i in nums.size / 2 until nums.size) {
            for (x in sums2.toList()) {
                if (!sums2.add(x + nums[i])) {
                    continue
                }
                val target = goal - x - nums[i]
                var lo = 0
                var hi = sortedSums1.size
                while (lo < hi) {
                    val mid = (lo + hi) / 2
                    if (sortedSums1[mid] < target) lo = mid + 1 else hi = mid
                }
                if (lo < sortedSums1.size) {
                    result = minOf(result, abs(target - sortedSums1[lo]))
                }
                if (lo > 0) {
                    result = minOf(result, abs(target - sortedSums1[lo - 1]))
                }
                if (result == 0) {
                    return result
                }
            }
        }
        return result
    }
}
