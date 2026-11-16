package mergesimilaritems
// Time:  O((m + n) * log(m + n))
// Space: O(m + n)

class Solution {
    fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): Array<IntArray> {
        val cnt = hashMapOf<Int, Int>()
        for (x in items1) {
            cnt[x[0]] = cnt.getOrDefault(x[0], 0) + x[1]
        }
        for (x in items2) {
            cnt[x[0]] = cnt.getOrDefault(x[0], 0) + x[1]
        }
        val result = mutableListOf<IntArray>()
        for ((k, v) in cnt) {
            result.add(intArrayOf(k, v))
        }
        result.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        return result.toTypedArray()
    }
}
