package encodenarytreetobinarytree
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Node(
    var `val`: Int = 0,
    var children: MutableList<Node?> = mutableListOf()
)

class Codec {
    fun encode(root: Node?): TreeNode? {
        if (root == null) {
            return null
        }
        val node = TreeNode(root.`val`)
        if (root.children.isNotEmpty()) {
            node.right = encodeHelper(root.children[0], root, 0)
        }
        return node
    }

    fun decode(root: TreeNode?): Node? {
        if (root == null) {
            return null
        }
        val node = Node(root.`val`)
        decodeHelper(root.right, node)
        return node
    }

    private fun encodeHelper(root: Node?, parent: Node, index: Int): TreeNode? {
        if (root == null) {
            return null
        }
        val node = TreeNode(root.`val`)
        if (index + 1 < parent.children.size) {
            node.left = encodeHelper(parent.children[index + 1], parent, index + 1)
        }
        if (root.children.isNotEmpty()) {
            node.right = encodeHelper(root.children[0], root, 0)
        }
        return node
    }

    private fun decodeHelper(root: TreeNode?, parent: Node) {
        if (root == null) {
            return
        }
        val node = Node(root.`val`)
        decodeHelper(root.right, node)
        parent.children.add(node)
        decodeHelper(root.left, parent)
    }
}
