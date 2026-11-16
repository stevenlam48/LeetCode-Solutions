package countofrangesum

// Time:  O(nlogn)
// Space: O(n)

// Divide and Conquer solution.
class Solution {
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        val sums = LongArray(nums.size + 1)
        for (i in nums.indices) {
            sums[i + 1] = sums[i] + nums[i]
        }
        return countAndMergeSort(sums, 0, sums.size, lower, upper)
    }

    private fun countAndMergeSort(sums: LongArray, start: Int, end: Int, lower: Int, upper: Int): Int {
        if (end - start <= 1) {
            return 0
        }
        val mid = start + (end - start) / 2
        var count = countAndMergeSort(sums, start, mid, lower, upper) +
            countAndMergeSort(sums, mid, end, lower, upper)
        var j = mid
        var k = mid
        var r = mid
        val tmp = ArrayList<Long>()
        for (i in start until mid) {
            while (k < end && sums[k] - sums[i] < lower) {
                ++k
            }
            while (j < end && sums[j] - sums[i] <= upper) {
                ++j
            }
            count += j - k
            while (r < end && sums[r] < sums[i]) {
                tmp.add(sums[r++])
            }
            tmp.add(sums[i])
        }
        for (t in tmp.indices) {
            sums[start + t] = tmp[t]
        }
        return count
    }
}
