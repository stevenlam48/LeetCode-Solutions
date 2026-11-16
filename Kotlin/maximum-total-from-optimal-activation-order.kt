package maximumtotalfromoptimalactivationorder
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxTotal(value: IntArray, limit: IntArray): Long {
        val idxs = value.indices.sortedWith(compareBy<Int>({ limit[it] }, { -value[it] }))
        var result = 0L
        var cnt = 0
        var prev = 0
        for (i in idxs) {
            val l = limit[i]
            val v = value[i]
            if (l != prev) {
                cnt = 0
                prev = l
            }
            if (cnt < l) {
                result += v
                ++cnt
            }
        }
        return result
    }
}
