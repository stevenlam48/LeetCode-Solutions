package checkiftwoexpressiontreesareequivalent

// Time:  O(n)
// Space: O(h)

class Node(var `val`: Char) {
    var left: Node? = null
    var right: Node? = null
}

class Solution {
    fun checkEquivalence(root1: Node?, root2: Node?): Boolean {
        val count = HashMap<Char, Int>()
        var prev = '+'
        morrisInorderTraversal(root1) { c ->
            addCounter(count, prev, 1, c)
            prev = c
        }
        prev = '+'
        morrisInorderTraversal(root2) { c ->
            addCounter(count, prev, -1, c)
            prev = c
        }
        return count.values.all { it == 0 }
    }

    private fun addCounter(count: HashMap<Char, Int>, prev: Char, d: Int, value: Char) {
        if (value.isLetter()) {
            count[value] = (count[value] ?: 0) + if (prev == '+') d else -d
        }
    }

    private fun morrisInorderTraversal(root: Node?, cb: (Char) -> Unit) {
        var curr = root
        while (curr != null) {
            if (curr.left == null) {
                cb(curr.`val`)
                curr = curr.right
            } else {
                var node: Node = curr.left!!
                while (node.right != null && node.right !== curr) {
                    node = node.right!!
                }
                if (node.right == null) {
                    node.right = curr
                    curr = curr.left
                } else {
                    cb(curr.`val`)
                    node.right = null
                    curr = curr.right
                }
            }
        }
    }
}
