package largestvaluesfromlabels

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun largestValsFromLabels(values: IntArray, labels: IntArray, num_wanted: Int, use_limit: Int): Int {
        val valLabs = values.indices.map { values[it] to labels[it] }
            .sortedWith(compareByDescending<Pair<Int, Int>> { it.first }.thenByDescending { it.second })
        val count = HashMap<Int, Int>()
        var remaining = num_wanted
        var result = 0
        var i = 0
        while (remaining != 0 && i < valLabs.size) {
            val (value, label) = valLabs[i]
            if ((count[label] ?: 0) < use_limit) {
                result += value
                count[label] = (count[label] ?: 0) + 1
                --remaining
            }
            ++i
        }
        return result
    }
}
