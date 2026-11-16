package closestbinarysearchtreevalue

import common.TreeNode
import kotlin.math.abs

// Time:  O(h)
// Space: O(1)
class Solution {
    fun closestValue(root: TreeNode?, target: Double): Int {
        var gap = Double.MAX_VALUE
        var closest = Int.MAX_VALUE
        var current = root
        while (current != null) {
            if (abs(current.`val`.toDouble() - target) < gap) {
                gap = abs(current.`val` - target)
                closest = current.`val`
            }
            when {
                target == current.`val`.toDouble() -> break
                target < current.`val` -> current = current.left
                else -> current = current.right
            }
        }
        return closest
    }
}
