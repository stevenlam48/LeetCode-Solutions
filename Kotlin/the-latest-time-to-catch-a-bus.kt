package thelatesttimetocatchabus

// Time:  O(nlogn + mlogm)
// Space: O(1)

class Solution {
    fun latestTimeCatchTheBus(buses: IntArray, passengers: IntArray, capacity: Int): Int {
        buses.sort()
        passengers.sort()
        var cnt = 0
        var j = 0
        for (i in 0 until buses.size - 1) {
            while (j < passengers.size && passengers[j] <= buses[i]) {
                ++cnt
                ++j
            }
            cnt = Math.max(cnt - capacity, 0)
        }
        j -= Math.max(cnt - capacity, 0)
        cnt = Math.min(cnt, capacity)
        while (j < passengers.size && passengers[j] <= buses.last() && cnt + 1 <= capacity) {
            ++cnt
            ++j
        }
        if (cnt < capacity && (j - 1 < 0 || passengers[j - 1] != buses.last())) {
            return buses.last()
        }
        --j
        while (j > 0) {
            if (passengers[j] - 1 != passengers[j - 1]) {
                break
            }
            --j
        }
        return passengers[j] - 1
    }
}
