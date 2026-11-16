package smallestrectangleenclosingblackpixels
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minArea(image: Array<CharArray>, x: Int, y: Int): Int {
        val searchColumns: (Boolean, Int) -> Boolean = { hasOne, mid ->
            hasOne == image.any { row -> row[mid] == '1' }
        }
        val searchRows: (Boolean, Int) -> Boolean = { hasOne, mid ->
            hasOne == image[mid].any { col -> col == '1' }
        }
        val left = binarySearch(0, y - 1) { mid -> searchColumns(true, mid) }
        val right = binarySearch(y + 1, image[0].size - 1) { mid -> searchColumns(false, mid) }
        val top = binarySearch(0, x - 1) { mid -> searchRows(true, mid) }
        val bottom = binarySearch(x + 1, image.size - 1) { mid -> searchRows(false, mid) }
        return (right - left) * (bottom - top)
    }

    private fun binarySearch(left: Int, right: Int, find: (Int) -> Boolean): Int {
        var l = left
        var r = right
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (find(mid)) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return l
    }
}
