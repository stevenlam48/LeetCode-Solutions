package minimumbishopmovestoreachtarget

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minBishopMoves(source: IntArray, target: IntArray): Int {
        if ((source[0] + target[0]) % 2 != (source[1] + target[1]) % 2) {
            return -1
        }
        return if (kotlin.math.abs(source[0] - target[0]) == kotlin.math.abs(source[1] - target[1])) 1 else 2
    }
}
