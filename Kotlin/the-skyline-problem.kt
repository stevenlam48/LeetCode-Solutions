package theskylineproblem

import java.util.TreeMap

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    private data class Endpoint(val height: Int, val isStart: Boolean)

    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        val pointToHeight = TreeMap<Int, MutableList<Endpoint>>()
        for (building in buildings) {
            pointToHeight.getOrPut(building[0]) { ArrayList() }.add(Endpoint(building[2], true))
            pointToHeight.getOrPut(building[1]) { ArrayList() }.add(Endpoint(building[2], false))
        }

        val res = ArrayList<List<Int>>()
        val heightToCount = TreeMap<Int, Int>()
        var currMax = 0
        for ((point, heights) in pointToHeight) {
            for (h in heights) {
                if (h.isStart) {
                    heightToCount[h.height] = (heightToCount[h.height] ?: 0) + 1
                } else {
                    val cnt = heightToCount[h.height]!! - 1
                    if (cnt == 0) {
                        heightToCount.remove(h.height)
                    } else {
                        heightToCount[h.height] = cnt
                    }
                }
            }

            if (heightToCount.isEmpty() || currMax != heightToCount.lastKey()) {
                currMax = if (heightToCount.isEmpty()) 0 else heightToCount.lastKey()
                res.add(listOf(point, currMax))
            }
        }
        return res
    }
}
