package maximumpricetofillabag
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxPrice(items: Array<IntArray>, capacity: Int): Double {
        items.sortWith(Comparator { a, b ->
            when {
                a[0] * b[1] > a[1] * b[0] -> -1
                a[0] * b[1] < a[1] * b[0] -> 1
                else -> 0
            }
        })
        var remainingCapacity = capacity
        var result = 0.0
        for (item in items) {
            val count = minOf(item[1], remainingCapacity)
            remainingCapacity -= count
            result += item[0].toDouble() / item[1] * count
        }
        return if (remainingCapacity == 0) result else -1.0
    }
}
