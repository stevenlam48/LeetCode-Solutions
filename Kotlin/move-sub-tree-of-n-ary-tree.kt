package movesubtreeofnarytree

// Time:  O(n)
// Space: O(h)

class Node() {
    var `val`: Int = 0
    var children: MutableList<Node> = mutableListOf()

    constructor(`val`: Int) : this() {
        this.`val` = `val`
    }

    constructor(`val`: Int, children: MutableList<Node>) : this() {
        this.`val` = `val`
        this.children = children
    }
}

class Solution {
    private data class Frame(
        val step: Int,
        val node: Node?,
        val parent: Node?,
        val isAncestor: Boolean,
        val i: Int
    )

    fun moveSubTree(root: Node?, p: Node, q: Node): Node? {
        val lookup = HashMap<Node, Node?>()
        val isAncestor = iterFindParents(root, null, p, q, false, lookup)
        if (lookup.containsKey(p) && lookup[p] === q) {
            return root
        }
        q.children.add(p)
        if (!isAncestor) {
            lookup[p]!!.children.remove(p)
        } else {
            lookup[q]!!.children.remove(q)
            if (p === root) {
                return q
            } else {
                val parent = lookup[p]!!
                parent.children[parent.children.indexOf(p)] = q
            }
        }
        return root
    }

    private fun iterFindParents(
        node: Node?,
        parent: Node?,
        p: Node,
        q: Node,
        isAncestor: Boolean,
        lookup: HashMap<Node, Node?>
    ): Boolean {
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, node, parent, isAncestor, -1))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            if (frame.step == 1) {
                if (frame.node === p || frame.node === q) {
                    lookup[frame.node!!] = frame.parent
                    if (lookup.size == 2) {
                        return frame.isAncestor
                    }
                }
                stk.addLast(Frame(2, frame.node, frame.parent, frame.isAncestor, frame.node!!.children.size - 1))
            } else {
                if (frame.i < 0) {
                    continue
                }
                stk.addLast(Frame(2, frame.node, frame.parent, frame.isAncestor, frame.i - 1))
                stk.addLast(
                    Frame(
                        1,
                        frame.node!!.children[frame.i],
                        frame.node,
                        frame.isAncestor || frame.node === p,
                        -1
                    )
                )
            }
        }
        return false
    }
}
