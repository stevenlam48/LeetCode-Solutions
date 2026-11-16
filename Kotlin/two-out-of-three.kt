package twooutofthree

// Time:  O(n)
// Space: O(min(n, r)), r is the range size of nums

class Solution {
    fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
        val K = 2
        val cnt = HashMap<Int, Int>()
        val result = ArrayList<Int>()
        for (nums in listOf(nums1, nums2, nums3)) {
            for (x in nums.toSet()) {
                val c = (cnt[x] ?: 0) + 1
                cnt[x] = c
                if (c == K) {
                    result.add(x)
                }
            }
        }
        return result
    }
}
