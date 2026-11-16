package maximumwhitetilescoveredbyacarpet

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumWhiteTiles(tiles: Array<IntArray>, carpetLen: Int): Int {
        tiles.sortWith(compareBy({ it[0] }, { it[1] }))
        var result = 0
        var right = 0
        var gap = 0
        for (left in tiles.indices) {
            if (left - 1 >= 0) {
                gap -= tiles[left][0] - tiles[left - 1][1] - 1
            }
            val r = tiles[left][0] + carpetLen - 1
            while (right + 1 < tiles.size && r + 1 >= tiles[right + 1][0]) {
                right++
                gap += tiles[right][0] - tiles[right - 1][1] - 1
            }
            result = maxOf(result, minOf(tiles[right][1] - tiles[left][0] + 1, carpetLen) - gap)
        }
        return result
    }
}
