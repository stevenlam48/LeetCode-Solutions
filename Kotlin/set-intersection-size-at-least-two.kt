package setintersectionsizeatleasttwo

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
        val ordered = intervals.sortedWith(
            compareBy<IntArray> { it[0] }.thenByDescending { it[1] }
        ).toMutableList()
        val counts = MutableList(ordered.size) { 2 }
        var result = 0
        while (ordered.isNotEmpty()) {
            val start = ordered.last()[0]
            ordered.removeAt(ordered.lastIndex)
            val count = counts.removeAt(counts.lastIndex)
            for (s in start until start + count) {
                for (i in ordered.indices) {
                    if (counts[i] != 0 && s <= ordered[i][1]) {
                        --counts[i]
                    }
                }
            }
            result += count
        }
        return result
    }
}
