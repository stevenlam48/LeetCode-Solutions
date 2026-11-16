package removingminimumnumberofmagicbeans
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minimumRemoval(beans: IntArray): Long {
        beans.sort()
        var result = 0L
        for (i in beans.indices) {
            result = maxOf(result, beans[i].toLong() * (beans.size - i))
        }
        return beans.sumOf { it.toLong() } - result
    }
}
