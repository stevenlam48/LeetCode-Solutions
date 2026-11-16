package designanexpressiontreewithevaluatefunction

// Time:  O(n)
// Space: O(h)

abstract class Node {
    abstract fun evaluate(): Int
}

private class Frame(
    val step: Int,
    val node: NodeIter,
    val ret1: IntArray?,
    val ret2: IntArray?,
    val ret: IntArray
)

class NodeIter : Node {
    var `val`: Int = 0
    var op: Char = '\u0000'
    var left: NodeIter? = null
    var right: NodeIter? = null

    constructor(value: Int) {
        `val` = value
    }

    constructor(op: Char, left: NodeIter?, right: NodeIter?) {
        this.op = op
        this.left = left
        this.right = right
    }

    override fun evaluate(): Int {
        val result = IntArray(1)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, this, null, null, result))
        while (stk.isNotEmpty()) {
            val f = stk.removeLast()
            if (f.step == 1) {
                val node = f.node
                if (node.op == '\u0000') {
                    f.ret[0] = node.`val`
                    continue
                }
                val ret1 = IntArray(1)
                val ret2 = IntArray(1)
                stk.addLast(Frame(2, node, ret1, ret2, f.ret))
                stk.addLast(Frame(1, node.right!!, null, null, ret2))
                stk.addLast(Frame(1, node.left!!, null, null, ret1))
            } else {
                val l = f.ret1!![0]
                val r = f.ret2!![0]
                f.ret[0] = when (f.node.op) {
                    '+' -> l + r
                    '-' -> l - r
                    '*' -> l * r
                    '/' -> l / r
                    else -> 0
                }
            }
        }
        return result[0]
    }
}

class TreeBuilder {
    fun buildTree(postfix: List<String>): Node {
        val stk = ArrayDeque<NodeIter>()
        for (s in postfix) {
            if (s[0].isDigit()) {
                stk.addLast(NodeIter(s.toInt()))
            } else {
                val right = stk.removeLast()
                val left = stk.removeLast()
                stk.addLast(NodeIter(s[0], left, right))
            }
        }
        return stk.last()
    }
}
