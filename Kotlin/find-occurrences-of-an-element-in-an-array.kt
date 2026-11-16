package findoccurrencesofanelementinanarray

// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun occurrencesOfElement(nums: IntArray, queries: IntArray, x: Int): IntArray {
        val lookup = mutableListOf<Int>()
        for (i in nums.indices) {
            if (nums[i] != x) {
                continue
            }
            lookup.add(i)
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            result[i] = if (queries[i] - 1 < lookup.size) lookup[queries[i] - 1] else -1
        }
        return result
    }
}
