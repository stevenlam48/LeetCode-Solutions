package altandtabsimulation

// Time:  O(n)
// Space: O(n)

// hash table
class Solution {
    fun simulationResult(windows: IntArray, queries: IntArray): List<Int> {
        val lookup = BooleanArray(windows.size + 1)
        val result = mutableListOf<Int>()
        for (i in queries.size - 1 downTo 0) {
            if (lookup[queries[i]]) {
                continue
            }
            lookup[queries[i]] = true
            result.add(queries[i])
        }
        for (x in windows) {
            if (lookup[x]) {
                continue
            }
            result.add(x)
        }
        return result
    }
}
