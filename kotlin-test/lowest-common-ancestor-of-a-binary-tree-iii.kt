package lowestcommonancestorofabinarytreeiii

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class LowestCommonAncestorOfABinaryTreeIiiTest {
    @Test
    fun findsAncestorInDifferentSubtrees() {
        val root = parentTreeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val result = Solution().lowestCommonAncestor(node(root, 5), node(root, 1))
        assertSame(node(root, 3), result)
    }

    @Test
    fun returnsAncestorThatIsAlsoTarget() {
        val root = parentTreeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val result = Solution().lowestCommonAncestor(node(root, 5), node(root, 4))
        assertSame(node(root, 5), result)
    }

    @Test
    fun handlesSameTargetTwice() {
        val root = parentTreeOf(3, 5, 1)
        val target = node(root, 5)
        assertSame(target, Solution().lowestCommonAncestor(target, target))
    }

    @Test
    fun handlesNullTargets() {
        assertNull(Solution().lowestCommonAncestor(null, null))
    }
}

private fun parentTreeOf(vararg values: Int?): Node? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = Node(values[0]!!)
    val queue = ArrayDeque<Node>()
    queue.add(root)
    var i = 1
    while (i < values.size && queue.isNotEmpty()) {
        val parent = queue.removeFirst()
        values[i++]?.let {
            val child = Node(it)
            child.parent = parent
            parent.left = child
            queue.add(child)
        }
        if (i < values.size) {
            values[i++]?.let {
                val child = Node(it)
                child.parent = parent
                parent.right = child
                queue.add(child)
            }
        }
    }
    return root
}

private fun node(root: Node?, value: Int): Node {
    val queue = ArrayDeque<Node>()
    root?.let(queue::add)
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        if (current.`val` == value) {
            return current
        }
        current.left?.let(queue::add)
        current.right?.let(queue::add)
    }
    throw IllegalArgumentException("Missing node $value")
}
