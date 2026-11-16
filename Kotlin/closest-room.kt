package closestroom

// Time:  O(nlogn + klogk + klogn)
// Space: O(n + k)


import java.util.TreeSet
import kotlin.math.abs

class Solution {
    fun closestRoom(rooms: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val sortedRooms = rooms.sortedWith(compareByDescending { it[1] })
        val order = queries.indices.sortedWith(compareByDescending { queries[it][1] })
        val ids = TreeSet<Int>()
        val result = IntArray(queries.size) { -1 }
        var i = 0
        for (idx in order) {
            val r = queries[idx][0]
            val s = queries[idx][1]
            while (i < sortedRooms.size && sortedRooms[i][1] >= s) {
                ids.add(sortedRooms[i][0])
                ++i
            }
            result[idx] = findClosest(ids, r)
        }
        return result
    }

    private fun findClosest(ids: TreeSet<Int>, r: Int): Int {
        var result = -1
        var minDiff = Int.MAX_VALUE
        val lo = ids.floor(r)
        val hi = ids.ceiling(r)
        if (lo != null && abs(lo - r) < minDiff) {
            minDiff = abs(lo - r)
            result = lo
        }
        if (hi != null && abs(hi - r) < minDiff) {
            minDiff = abs(hi - r)
            result = hi
        }
        return result
    }
}
