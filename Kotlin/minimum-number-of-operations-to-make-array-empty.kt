package minimumnumberofoperationstomakearrayempty

// Time:  O(n)
// Space: O(n)

// freq table, greedy
class Solution {
    fun minOperations(nums: IntArray): Int {
        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        var result = 0
        for (c in cnt.values) {
            if (c < 2) {
                return -1
            }
            result += ceilDivide(c, 3)
        }
        return result
    }
}
