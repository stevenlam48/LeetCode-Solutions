package furthestpointfromorigin

import kotlin.math.abs

// Time:  O(n)
// Space: O(1)

// math
class Solution {
    fun furthestDistanceFromOrigin(moves: String): Int {
        var curr = 0
        var cnt = 0
        for (x in moves) {
            if (x == 'L') {
                --curr
            } else if (x == 'R') {
                ++curr
            } else {
                ++cnt
            }
        }
        return abs(curr) + cnt
    }
}
