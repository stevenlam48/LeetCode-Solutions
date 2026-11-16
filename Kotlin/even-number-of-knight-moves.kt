package evennumberofknightmoves

// Time:  O(1)
// Space: O(1)
class Solution {
    fun canReach(start: IntArray, target: IntArray): Boolean {
        return (start[0] + start[1]) % 2 == (target[0] + target[1]) % 2
    }
}
