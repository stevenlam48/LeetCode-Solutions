package determineiftwoeventshaveconflict

// Time:  O(1)
// Space: O(1)

class Solution {
    fun haveConflict(event1: List<String>, event2: List<String>): Boolean =
        maxOf(event1[0], event2[0]) <= minOf(event1[1], event2[1])
}
