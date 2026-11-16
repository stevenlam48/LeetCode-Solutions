package maximumgap

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumGap(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }

        var maxVal = nums[0]
        var minVal = nums[0]
        for (n in nums) {
            maxVal = maxOf(maxVal, n)
            minVal = minOf(minVal, n)
        }
        val gap = maxOf(1, (maxVal - minVal) / (nums.size - 1))
        val size = (maxVal - minVal) / gap + 1
        val bucketMin = IntArray(size) { Int.MAX_VALUE }
        val bucketMax = IntArray(size) { Int.MIN_VALUE }

        for (n in nums) {
            if (n == maxVal || n == minVal) {
                continue
            }
            val i = (n - minVal) / gap
            bucketMin[i] = minOf(bucketMin[i], n)
            bucketMax[i] = maxOf(bucketMax[i], n)
        }

        var maxGap = 0
        var preBucketMax = minVal
        for (i in 0 until size) {
            if (bucketMin[i] != Int.MAX_VALUE) {
                maxGap = maxOf(maxGap, bucketMin[i] - preBucketMax)
                preBucketMax = bucketMax[i]
            }
        }
        maxGap = maxOf(maxGap, maxVal - preBucketMax)

        return maxGap
    }
}
