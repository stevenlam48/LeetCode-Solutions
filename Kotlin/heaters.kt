package heaters

// Time:  O((m + n) * logn), m is the number of the houses, n is the number of the heaters.
// Space: O(1)
class Solution {
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        heaters.sort()
        var minRadius = 0
        for (house in houses) {
            val position = heaters.binarySearch(house)
            val equalOrLarger = if (position >= 0) position else -position - 1
            var currRadius = Int.MAX_VALUE
            if (equalOrLarger < heaters.size) {
                currRadius = heaters[equalOrLarger] - house
            }
            if (equalOrLarger > 0) {
                currRadius = minOf(currRadius, house - heaters[equalOrLarger - 1])
            }
            minRadius = maxOf(minRadius, currRadius)
        }
        return minRadius
    }
}
