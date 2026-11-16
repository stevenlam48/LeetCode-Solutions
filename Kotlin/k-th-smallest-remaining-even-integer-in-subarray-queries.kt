package kthsmallestremainingevenintegerinsubarrayqueries

// Time:  O(n + qlogn)
// Space: O(n)

class Solution {
    fun kthRemainingInteger(nums: IntArray, queries: Array<IntArray>): IntArray {
        fun binarySearchRight(left: Int, right: Int, check: (Int) -> Boolean): Int {
            var l = left
            var r = right
            while (l <= r) {
                val mid = l + (r - l) / 2
                if (!check(mid)) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
            return r
        }

        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + if (nums[i] % 2 == 0) 1 else 0
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val l = queries[i][0]
            val r = queries[i][1]
            val k = queries[i][2]
            val j = binarySearchRight(l, r) { x ->
                nums[x] / 2 < k + (prefix[x + 1] - prefix[l])
            }
            result[i] = 2 * (k + (prefix[j + 1] - prefix[l]))
        }
        return result
    }
}
