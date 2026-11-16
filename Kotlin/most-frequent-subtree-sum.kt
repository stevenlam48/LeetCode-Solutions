package mostfrequentsubtreesum
// Time:  O(n)
// Space: O(n)

import common.TreeNode

class Solution {
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val counts = HashMap<Int, Int>()
        var maxCount = 0

        fun countSubtreeSums(node: TreeNode?): Int {
            if (node == null) {
                return 0
            }
            val sum = node.`val` + countSubtreeSums(node.left) + countSubtreeSums(node.right)
            counts[sum] = counts.getOrDefault(sum, 0) + 1
            maxCount = maxOf(maxCount, counts.getValue(sum))
            return sum
        }

        countSubtreeSums(root)
        val result = mutableListOf<Int>()
        for ((sum, count) in counts) {
            if (count == maxCount) {
                result.add(sum)
            }
        }
        return result.toIntArray()
    }
}
