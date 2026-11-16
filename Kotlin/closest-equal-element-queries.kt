package closestequalelementqueries

// Time:  O(n)
// Space: O(n)

class Solution {
    fun solveQueries(nums: IntArray, queries: IntArray): IntArray {
        val dist = IntArray(nums.size) { nums.size }
        val left = HashMap<Int, Int>()
        for (i in 0 until 2 * nums.size - 1) {
            val x = nums[i % nums.size]
            if (left.containsKey(x)) {
                dist[i % nums.size] = minOf(dist[i % nums.size], i - left[x]!!)
            }
            left[x] = i
        }
        val right = HashMap<Int, Int>()
        for (i in 2 * nums.size - 2 downTo 0) {
            val x = nums[i % nums.size]
            if (right.containsKey(x)) {
                dist[i % nums.size] = minOf(dist[i % nums.size], right[x]!! - i)
            }
            right[x] = i
        }
        val result = IntArray(queries.size) { -1 }
        for (i in queries.indices) {
            if (dist[queries[i]] < nums.size) {
                result[i] = dist[queries[i]]
            }
        }
        return result
    }
}
