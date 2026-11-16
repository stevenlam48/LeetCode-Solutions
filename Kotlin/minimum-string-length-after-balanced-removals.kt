package minimumstringlengthafterbalancedremovals

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minLengthAfterRemovals(s: String): Int {
        return kotlin.math.abs(s.count { it == 'a' } - s.count { it == 'b' })
    }
}
