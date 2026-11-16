package specialpermutations

// Time:  O(n^2 * 2^n)
// Space: O(n * 2^n)

class Solution {
    fun specialPerm(nums: IntArray): Int {
        val MOD = 1_000_000_007
        val n = nums.size

        val lookup = Array(n + 1) { IntArray(1 shl n) { -1 } }
        fun backtracking(i: Int, mask: Int): Int {
            if (mask == (1 shl n) - 1) {
                return 1
            }
            if (lookup[i + 1][mask] == -1) {
                var total = 0
                for (j in 0 until n) {
                    if (mask and (1 shl j) != 0) {
                        continue
                    }
                    if (!(i == -1 || nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0)) {
                        continue
                    }
                    total = (total + backtracking(j, mask or (1 shl j))) % MOD
                }
                lookup[i + 1][mask] = total
            }
            return lookup[i + 1][mask]
        }

        return backtracking(-1, 0)
    }
}
