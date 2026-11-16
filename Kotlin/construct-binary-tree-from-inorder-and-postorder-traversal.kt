package constructbinarytreefrominorderandpostordertraversal

import common.TreeNode

// Time:  O(n)
// Space: O(n)

class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val inEntryIdxMap = HashMap<Int, Int>()
        for (i in inorder.indices) {
            inEntryIdxMap[inorder[i]] = i
        }
        return reconstructPostInOrdersHelper(
            postorder, 0, postorder.size,
            inorder, 0, inorder.size,
            inEntryIdxMap
        )
    }

    fun reconstructPostInOrdersHelper(
        postorder: IntArray, postS: Int, postE: Int,
        inorder: IntArray, inS: Int, inE: Int,
        inEntryIdxMap: Map<Int, Int>
    ): TreeNode? {
        if (postS == postE || inS == inE) {
            return null
        }

        val idx = inEntryIdxMap.getValue(postorder[postE - 1])
        val leftTreeSize = idx - inS

        val node = TreeNode(postorder[postE - 1])
        node.left = reconstructPostInOrdersHelper(
            postorder, postS, postS + leftTreeSize,
            inorder, inS, idx, inEntryIdxMap
        )
        node.right = reconstructPostInOrdersHelper(
            postorder, postS + leftTreeSize, postE - 1,
            inorder, idx + 1, inE, inEntryIdxMap
        )
        return node
    }
}
