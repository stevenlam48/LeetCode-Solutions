package xorqueriesofasubarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        for (i in 1 until arr.size) arr[i] = arr[i] xor arr[i - 1]
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val left = queries[i][0]
            val right = queries[i][1]
            result[i] = if (left != 0) arr[right] xor arr[left - 1] else arr[right]
        }
        return result
    }
}
