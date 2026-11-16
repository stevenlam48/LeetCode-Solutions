package maximumbagswithfullcapacityofrocks

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        for (i in capacity.indices) {
            capacity[i] -= rocks[i]
        }
        capacity.sort()
        var remaining = additionalRocks
        for (i in capacity.indices) {
            if (capacity[i] > remaining) {
                return i
            }
            remaining -= capacity[i]
        }
        return capacity.size
    }
}
