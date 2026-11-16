package timetocrossabridge
// Time:  O(k + nlogk)
// Space: O(k)

import java.util.PriorityQueue

class Solution {
    fun findCrossingTime(n: Int, k: Int, time: Array<IntArray>): Int {
        val descending = compareByDescending<Pair<Int, Int>> { it.first }.thenByDescending { it.second }
        val ascending = compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
        val leftBridge = PriorityQueue<Pair<Int, Int>>(descending)
        val rightBridge = PriorityQueue<Pair<Int, Int>>(descending)
        val leftWarehouse = PriorityQueue<Pair<Int, Int>>(ascending)
        val rightWarehouse = PriorityQueue<Pair<Int, Int>>(ascending)
        for (i in 0 until k) {
            leftBridge.add(Pair(time[i][0] + time[i][2], i))
        }

        var remaining = n
        var current = 0
        while (remaining != 0) {
            while (leftWarehouse.isNotEmpty() && leftWarehouse.peek().first <= current) {
                val i = leftWarehouse.poll().second
                leftBridge.add(Pair(time[i][0] + time[i][2], i))
            }
            while (rightWarehouse.isNotEmpty() && rightWarehouse.peek().first <= current) {
                val i = rightWarehouse.poll().second
                rightBridge.add(Pair(time[i][0] + time[i][2], i))
            }
            if (rightBridge.isNotEmpty()) {
                val i = rightBridge.poll().second
                current += time[i][2]
                leftWarehouse.add(Pair(current + time[i][3], i))
                --remaining
            } else if (leftBridge.isNotEmpty() && remaining - rightWarehouse.size != 0) {
                val i = leftBridge.poll().second
                current += time[i][0]
                rightWarehouse.add(Pair(current + time[i][1], i))
            } else {
                val leftTime = if (leftWarehouse.isNotEmpty()) leftWarehouse.peek().first else Int.MAX_VALUE
                val rightTime = if (rightWarehouse.isNotEmpty()) rightWarehouse.peek().first else Int.MAX_VALUE
                current = minOf(leftTime, rightTime)
            }
        }
        return current
    }
}
