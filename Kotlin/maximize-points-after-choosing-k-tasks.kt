package maximizepointsafterchoosingktasks

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxPoints(technique1: IntArray, technique2: IntArray, k: Int): Long {
        val idxs = technique1.indices
            .sortedByDescending { technique1[it] - technique2[it] }
            .toIntArray()
        var result = 0L
        for (i in technique1.indices) {
            result += if (i < k) {
                technique1[idxs[i]]
            } else {
                maxOf(technique1[idxs[i]], technique2[idxs[i]])
            }
        }
        return result
    }
}
