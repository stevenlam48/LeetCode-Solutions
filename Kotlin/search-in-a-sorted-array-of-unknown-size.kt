package searchinasortedarrayofunknownsize

// Time:  O(logn)
// Space: O(1)

class ArrayReader(private val values: IntArray) {
    fun get(index: Int): Int {
        return if (index in values.indices) values[index] else Int.MAX_VALUE
    }
}

class Solution {
    fun search(reader: ArrayReader, target: Int): Int {
        var left = 0
        var right = 19999
        while (left <= right) {
            val mid = left + (right - left) / 2
            val response = reader.get(mid)
            if (response > target) {
                right = mid - 1
            } else if (response < target) {
                left = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }
}
