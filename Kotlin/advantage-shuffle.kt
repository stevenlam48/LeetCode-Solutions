package advantageshuffle

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun advantageCount(A: IntArray, B: IntArray): IntArray {
        val sortedA = A.sorted()
        val sortedB = B.sorted()
        val candidates = HashMap<Int, MutableList<Int>>()
        val others = mutableListOf<Int>()
        var j = 0
        for (a in sortedA) {
            if (a > sortedB[j]) {
                candidates.getOrPut(sortedB[j]) { mutableListOf() }.add(a)
                ++j
            } else {
                others.add(a)
            }
        }
        val result = mutableListOf<Int>()
        for (b in B) {
            val values = candidates[b]
            if (!values.isNullOrEmpty()) {
                result.add(values.removeAt(values.lastIndex))
            } else {
                result.add(others.removeAt(others.lastIndex))
            }
        }
        return result.toIntArray()
    }
}
