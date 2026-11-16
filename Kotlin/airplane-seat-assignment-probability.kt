package airplaneseatassignmentprobability

// Time:  O(1)
// Space: O(1)

class Solution {
    fun nthPersonGetsNthSeat(n: Int): Double {
        return if (n != 1) 0.5 else 1.0
    }
}
