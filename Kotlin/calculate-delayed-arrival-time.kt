package calculatedelayedarrivaltime

// Time:  O(1)
// Space: O(1)

class Solution {
    fun findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int): Int {
        return (arrivalTime + delayedTime) % 24
    }
}
