package findacorrespondingnodeofabinarytreeinacloneofthattree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTreeTest {
    @Test
    fun example1() {
        val original = treeOf(7, 4, 3, null, null, 6, 19)
        val cloned = treeOf(7, 4, 3, null, null, 6, 19)
        val target = find(original, 3)!!
        assertSame(find(cloned, 3), Solution().getTargetCopy(original, cloned, target))
    }

    @Test
    fun targetIsRoot() {
        val original = treeOf(7, 4, 3, null, null, 6, 19)
        val cloned = treeOf(7, 4, 3, null, null, 6, 19)
        val target = find(original, 7)!!
        assertSame(cloned, Solution().getTargetCopy(original, cloned, target))
    }

    @Test
    fun targetIsLeaf() {
        val original = treeOf(7, 4, 3, null, null, 6, 19)
        val cloned = treeOf(7, 4, 3, null, null, 6, 19)
        val target = find(original, 19)!!
        assertSame(find(cloned, 19), Solution().getTargetCopy(original, cloned, target))
    }

    @Test
    fun singleNode() {
        val original = treeOf(1)
        val cloned = treeOf(1)
        assertSame(cloned, Solution().getTargetCopy(original, cloned, original))
    }

    @Test
    fun leftSubtreeTarget() {
        val original = treeOf(1, 2, 3, 4, 5)
        val cloned = treeOf(1, 2, 3, 4, 5)
        val target = find(original, 4)!!
        assertSame(find(cloned, 4), Solution().getTargetCopy(original, cloned, target))
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val q = ArrayDeque<TreeNode>()
    q.addLast(root)
    var i = 1
    while (q.isNotEmpty() && i < v.size) {
        val node = q.removeFirst()
        if (i < v.size) {
            val x = v[i++]
            if (x != null) {
                node.left = TreeNode(x)
                q.addLast(node.left!!)
            }
        }
        if (i < v.size) {
            val x = v[i++]
            if (x != null) {
                node.right = TreeNode(x)
                q.addLast(node.right!!)
            }
        }
    }
    return root
}

private fun find(root: TreeNode?, value: Int): TreeNode? {
    if (root == null) {
        return null
    }
    if (root.`val` == value) {
        return root
    }
    return find(root.left, value) ?: find(root.right, value)
}
