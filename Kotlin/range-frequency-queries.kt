package rangefrequencyqueries

// Time:  ctor:  O(n)
//        query: O(logn)
// Space: O(n)

class RangeFreqQuery(arr: IntArray) {
    private val idxs = HashMap<Int, MutableList<Int>>()

    init {
        for (i in arr.indices) {
            idxs.getOrPut(arr[i]) { mutableListOf() }.add(i)
        }
    }

    fun query(left: Int, right: Int, value: Int): Int {
        val positions = idxs[value] ?: return 0
        return upperBound(positions, right) - lowerBound(positions, left)
    }

    private fun lowerBound(a: List<Int>, target: Int): Int {
        var left = 0
        var right = a.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (a[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    private fun upperBound(a: List<Int>, target: Int): Int {
        var left = 0
        var right = a.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (a[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
