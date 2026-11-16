package convertsortedarraytobinarysearchtree

import common.TreeNode

// Time:  O(n)
// Space: O(logn)

class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return sortedArrayToBSTHelper(nums, 0, nums.size - 1)
    }

    private fun sortedArrayToBSTHelper(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start <= end) {
            val mid = start + (end - start) / 2
            val node = TreeNode(nums[mid])
            node.left = sortedArrayToBSTHelper(nums, start, mid - 1)
            node.right = sortedArrayToBSTHelper(nums, mid + 1, end)
            return node
        }
        return null
    }
}
