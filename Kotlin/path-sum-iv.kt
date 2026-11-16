package pathsumiv

// Time:  O(n)
// Space: O(p), p is the number of paths

import java.util.ArrayDeque

class Solution {
    fun pathSum(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var result = 0
        val q = ArrayDeque<Node>()
        val dummy = Node(10)
        var parent = dummy
        for (num in nums) {
            val child = Node(num)
            while (!parent.isParent(child)) {
                result += if (parent.leaf) parent.`val` else 0
                parent = q.removeFirst()
            }
            parent.leaf = false
            child.`val` += parent.`val`
            q.addLast(child)
        }
        while (q.isNotEmpty()) {
            result += q.removeFirst().`val`
        }
        return result
    }

    private class Node(n: Int) {
        val level = n / 100 - 1
        val i = (n % 100) / 10 - 1
        var `val` = n % 10
        var leaf = true

        fun isParent(other: Node): Boolean = level == other.level - 1 && i == other.i / 2
    }
}
