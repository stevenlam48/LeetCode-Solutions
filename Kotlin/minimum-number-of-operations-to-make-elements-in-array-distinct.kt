package minimumnumberofoperationstomakeelementsinarraydistinct

// Time:  O(n + r)
// Space: O(r)

// freq table
class Solution {
    fun minimumOperations(nums: IntArray): Int {
        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        val mx = nums.max()
        val cnt = IntArray(mx)
        for (i in nums.size - 1 downTo 0) {
            if (++cnt[nums[i] - 1] == 2) {
                return ceilDivide(i + 1, 3)
            }
        }
        return 0
    }
}
