package minimumtimetotransportallindividuals

// Time:  O((n * m * 2^n + m * 3^n) * log(n * m * 2^n + m * 3^n)) = O(m * 3^n * log(m * 3^n))
// Space: O(n * m * 2^n + m * 3^n) = O(m * 3^n)

import java.util.PriorityQueue

private data class TransportState(val distance: Double, val side: Int, val stage: Int, val mask: Int)

class Solution {
    fun minTime(n: Int, k: Int, m: Int, time: IntArray, mul: DoubleArray): Double {
        val lookup = IntArray(1 shl n)
        for (mask in 1 until (1 shl n)) {
            for (i in 0 until n) {
                if (mask and (1 shl i) != 0) {
                    lookup[mask] = maxOf(lookup[mask], time[i])
                }
            }
        }
        val distance = Array(2) { Array(m) { DoubleArray(1 shl n) { Double.MAX_VALUE } } }
        distance[0][0][(1 shl n) - 1] = 0.0
        val heap = PriorityQueue(
            compareBy<TransportState> { it.distance }.thenBy { it.side }.thenBy { it.stage }.thenBy { it.mask }
        )
        heap.add(TransportState(0.0, 0, 0, (1 shl n) - 1))

        fun update(d: Double, side: Int, stage: Int, mask: Int, submask: Int) {
            val travelTime = lookup[submask] * mul[stage]
            val nextSide = side xor 1
            val nextStage = (stage + travelTime.toInt()) % m
            val nextMask = mask xor submask
            val nextDistance = d + travelTime
            if (distance[nextSide][nextStage][nextMask] > nextDistance) {
                distance[nextSide][nextStage][nextMask] = nextDistance
                heap.add(TransportState(nextDistance, nextSide, nextStage, nextMask))
            }
        }

        while (heap.isNotEmpty()) {
            val (d, side, stage, mask) = heap.poll()
            if (d != distance[side][stage][mask]) {
                continue
            }
            if (mask == 0) {
                return d
            }
            if (side == 0) {
                var submask = mask
                while (submask != 0) {
                    if (submask.countOneBits() <= k) {
                        update(d, side, stage, mask, submask)
                    }
                    submask = (submask - 1) and mask
                }
            } else {
                for (i in 0 until n) {
                    if (mask and (1 shl i) == 0) {
                        update(d, side, stage, mask, 1 shl i)
                    }
                }
            }
        }
        return -1.0
    }
}
