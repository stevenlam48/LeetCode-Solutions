package distancebetweenbusstops

import kotlin.math.min

// Time:  O(n)
// Space: O(1)

class Solution {
    fun distanceBetweenBusStops(distance: IntArray, start0: Int, destination0: Int): Int {
        var start = start0
        var destination = destination0
        if (start > destination) {
            val tmp = start
            start = destination
            destination = tmp
        }
        var sToD = 0
        for (i in start until destination) {
            sToD += distance[i]
        }
        var dToS = 0
        for (i in 0 until start) {
            dToS += distance[i]
        }
        for (i in destination until distance.size) {
            dToS += distance[i]
        }
        return min(sToD, dToS)
    }
}
