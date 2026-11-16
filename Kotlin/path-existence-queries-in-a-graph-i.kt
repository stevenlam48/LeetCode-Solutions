package pathexistencequeriesinagraphi

// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun pathExistenceQueries(
        n: Int,
        nums: IntArray,
        maxDiff: Int,
        queries: Array<IntArray>
    ): BooleanArray {
        val prefix = IntArray(n)
        for (i in 0 until n - 1) {
            prefix[i + 1] = prefix[i] + if (nums[i + 1] - nums[i] <= maxDiff) 0 else 1
        }
        val result = BooleanArray(queries.size)
        for (i in queries.indices) {
            result[i] = prefix[queries[i][0]] == prefix[queries[i][1]]
        }
        return result
    }
}
