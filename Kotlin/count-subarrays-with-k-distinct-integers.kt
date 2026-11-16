package countsubarrayswithkdistinctintegers

// Time:  O(n)
// Space: O(n)

// freq table, two pointers
class Solution {
    fun countSubarrays(nums: IntArray, k: Int, m: Int): Long {
        val cnt1 = HashMap<Int, Int>()
        val cnt2 = HashMap<Int, Int>()
        var result = 0L
        var left = 0
        var right = 0
        var l = 0
        for (x in nums) {
            cnt1[x] = (cnt1[x] ?: 0) + 1
            while (cnt1.size == k + 1) {
                val y = nums[left]
                cnt1[y] = cnt1[y]!! - 1
                if (cnt1[y] == 0) {
                    cnt1.remove(y)
                }
                ++left
            }
            cnt2[x] = (cnt2[x] ?: 0) + 1
            if (cnt2[x] == m) {
                ++l
            }
            while (l == k) {
                val y = nums[right]
                if (cnt2[y] == m) {
                    --l
                }
                cnt2[y] = cnt2[y]!! - 1
                if (cnt2[y] == 0) {
                    cnt2.remove(y)
                }
                ++right
            }
            result += maxOf(right - left, 0)
        }
        return result
    }
}
