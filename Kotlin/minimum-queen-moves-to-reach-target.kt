package minimumqueenmovestoreachtarget
// Time:  O(1)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun minQueenMoves(source: IntArray, target: IntArray): Int {
        return if (abs(source[0] - target[0]) == abs(source[1] - target[1]) &&
            abs(source[1] - target[1]) != 0
        ) {
            1
        } else {
            (if (source[0] != target[0]) 1 else 0) +
                (if (source[1] != target[1]) 1 else 0)
        }
    }
}
