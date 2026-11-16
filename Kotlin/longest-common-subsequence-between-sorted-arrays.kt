package longestcommonsubsequencebetweensortedarrays

// Time:  O(m * n)
// Space: O(l), l is min(len(arr) for arr in arrays)

class Solution {
    fun longestCommomSubsequence(arrays: Array<IntArray>): IntArray {
        val minIndex = arrays.indices.minBy { arrays[it].size }
        var result = arrays[minIndex].copyOf()
        for (index in arrays.indices) {
            if (index == minIndex) {
                continue
            }
            val newResult = mutableListOf<Int>()
            var i = 0
            var j = 0
            val current = arrays[index]
            while (i != result.size && j != current.size) {
                if (result[i] < current[j]) {
                    ++i
                } else if (result[i] > current[j]) {
                    ++j
                } else {
                    newResult.add(result[i])
                    ++i
                    ++j
                }
            }
            result = newResult.toIntArray()
        }
        return result
    }
}
