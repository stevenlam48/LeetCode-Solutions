package constructbinarytreefrompreorderandinordertraversal

import common.TreeNode

// Time:  O(n)
// Space: O(n)

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inEntryIdxMap = HashMap<Int, Int>()
        for (i in inorder.indices) {
            inEntryIdxMap[inorder[i]] = i
        }
        return reconstructPreInOrdersHelper(
            preorder, 0, preorder.size,
            inorder, 0, inorder.size,
            inEntryIdxMap
        )
    }

    fun reconstructPreInOrdersHelper(
        preorder: IntArray, preS: Int, preE: Int,
        inorder: IntArray, inS: Int, inE: Int,
        inEntryIdxMap: Map<Int, Int>
    ): TreeNode? {
        if (preS == preE || inS == inE) {
            return null
        }

        val idx = inEntryIdxMap.getValue(preorder[preS])
        val leftTreeSize = idx - inS

        val node = TreeNode(preorder[preS])
        node.left = reconstructPreInOrdersHelper(
            preorder, preS + 1, preS + 1 + leftTreeSize,
            inorder, inS, idx, inEntryIdxMap
        )
        node.right = reconstructPreInOrdersHelper(
            preorder, preS + 1 + leftTreeSize, preE,
            inorder, idx + 1, inE, inEntryIdxMap
        )
        return node
    }
}
