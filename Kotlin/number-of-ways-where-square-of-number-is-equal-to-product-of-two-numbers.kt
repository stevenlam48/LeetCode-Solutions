package numberofwayswheresquareofnumberisequaltoproductoftwonumbers

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun numTriplets(nums1: IntArray, nums2: IntArray): Int {
        var result = 0
        for (n in nums1) {
            result += twoProduct(nums2, n.toLong() * n)
        }
        for (n in nums2) {
            result += twoProduct(nums1, n.toLong() * n)
        }
        return result
    }

    private fun twoProduct(nums: IntArray, target: Long): Int {
        val lookup = HashMap<Long, Int>()
        var count = 0
        for (num in nums) {
            if (target % num != 0L) {
                continue
            }
            count += lookup.getOrDefault(target / num, 0)
            lookup[num.toLong()] = lookup.getOrDefault(num.toLong(), 0) + 1
        }
        return count
    }
}
