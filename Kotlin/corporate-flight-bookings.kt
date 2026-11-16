package corporateflightbookings

// Time:  O(n)
// Space: O(1)

class Solution {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val result = IntArray(n + 1)
        for (booking in bookings) {
            result[booking[0] - 1] += booking[2]
            result[booking[1]] -= booking[2]
        }
        for (i in 1 until result.size) {
            result[i] += result[i - 1]
        }
        return result.copyOfRange(0, n)
    }
}
