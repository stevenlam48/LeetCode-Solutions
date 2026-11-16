package minimumoperationstosortapermutation

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size

        fun check(i0: Int, d: Int): Boolean {
            for (j in 0 until n) {
                if (nums[((i0 + j * d) + n) % n] != j) {
                    return false
                }
            }
            return true
        }

        val idx = nums.indexOf(0)
        if (check(idx, 1)) {
            return minOf(idx, 1 + (n - idx) + 1)
        }
        if (check(idx, -1)) {
            return minOf((idx + 1) + 1, 1 + (n - (idx + 1)))
        }
        return -1
    }
}
