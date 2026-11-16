package escapetheghosts

import kotlin.math.abs

// Time:  O(n)
// Space: O(1)
class Solution {
    fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray): Boolean {
        val total = abs(target[0]) + abs(target[1])
        return ghosts.all { ghost ->
            total < abs(target[0] - ghost[0]) + abs(target[1] - ghost[1])
        }
    }
}
