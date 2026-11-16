package maximumtotalbeautyofthegardens
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumBeauty(flowers: IntArray, newFlowers: Long, target: Int, full: Int, partial: Int): Long {
        val a = flowers.filter { it < target }.sorted()
        val n = a.size.toLong()
        var prefix = 0L
        var suffix = 0L
        for (x in a) {
            suffix += x
        }
        var result = 0L
        var left = 0L
        var right = 0L
        while (right <= n) {
            if (right > 0) {
                suffix -= a[(right - 1).toInt()]
            }
            val total = newFlowers - ((n - right) * target - suffix)
            if (total >= 0) {
                while (!(left == right || (left > 0 && (total + prefix) / left <= a[left.toInt()]))) {
                    prefix += a[left.toInt()]
                    ++left
                }
                val mn = minOf(if (left > 0) (total + prefix) / left else 0L, target.toLong() - 1)
                result = maxOf(result, mn * partial + (flowers.size.toLong() - right) * full)
            }
            ++right
        }
        return result
    }
}
