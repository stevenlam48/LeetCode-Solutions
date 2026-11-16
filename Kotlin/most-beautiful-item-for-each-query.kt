package mostbeautifulitemforeachquery
// Time:  O(nlogn + qlogn)
// Space: O(1)

class Solution {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        items.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        for (i in 0 until items.size - 1) {
            items[i + 1][1] = maxOf(items[i + 1][1], items[i][1])
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val index = upperBound(items, queries[i])
            result[i] = if (index > 0) items[index - 1][1] else 0
        }
        return result
    }

    private fun upperBound(items: Array<IntArray>, price: Int): Int {
        var left = 0
        var right = items.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (items[mid][0] <= price) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
