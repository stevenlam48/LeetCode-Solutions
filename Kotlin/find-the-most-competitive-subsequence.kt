package findthemostcompetitivesubsequence

// Time:  O(n)
// Space: O(k)

class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val stk = ArrayList<Int>()
        for (i in nums.indices) {
            while (stk.isNotEmpty() && stk.last() > nums[i] &&
                stk.size + (nums.size - i) > k
            ) {
                stk.removeAt(stk.size - 1)
            }
            if (stk.size < k) {
                stk.add(nums[i])
            }
        }
        return stk.toIntArray()
    }
}
