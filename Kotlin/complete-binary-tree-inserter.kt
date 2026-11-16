package completebinarytreeinserter
// Time:  ctor:     O(n)
//        insert:   O(1)
//        get_root: O(1)
// Space: O(n)

import common.TreeNode

class CBTInserter(root: TreeNode) {
    private val tree = mutableListOf(root)

    init {
        var i = 0
        while (i < tree.size) {
            tree[i].left?.let { tree.add(it) }
            tree[i].right?.let { tree.add(it) }
            ++i
        }
    }

    fun insert(v: Int): Int {
        val n = tree.size
        val node = TreeNode(v)
        tree.add(node)
        if (n % 2 == 1) {
            tree[(n - 1) / 2].left = node
        } else {
            tree[(n - 1) / 2].right = node
        }
        return tree[(n - 1) / 2].`val`
    }

    fun getRoot(): TreeNode = tree[0]
}
