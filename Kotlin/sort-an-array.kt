package sortanarray

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun sortArray(nums: IntArray): IntArray {
        mergeSort(0, nums.size, nums)
        return nums
    }

    private fun mergeSort(start: Int, end: Int, nums: IntArray) {
        if (end - start <= 1) {
            return
        }
        val mid = start + (end - start) / 2
        mergeSort(start, mid, nums)
        mergeSort(mid, end, nums)
        val tmp = ArrayList<Int>()
        var right = mid
        for (left in start until mid) {
            while (right < end && nums[right] < nums[left]) {
                tmp.add(nums[right++])
            }
            tmp.add(nums[left])
        }
        for (i in tmp.indices) {
            nums[start + i] = tmp[i]
        }
    }
}
