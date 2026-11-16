package findtheindexofthelargeinteger

// Time:  O(logn)
// Space: O(1)

interface ArrayReader {
    fun length(): Int
    fun compareSub(l: Int, r: Int, x: Int, y: Int): Int
    fun get(index: Int): Int
}

class Solution {
    fun getIndex(reader: ArrayReader): Int {
        var left = 0
        var right = reader.length() - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (reader.compareSub(left, mid, if ((right - left + 1) % 2 != 0) mid else mid + 1, right) >= 0) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
