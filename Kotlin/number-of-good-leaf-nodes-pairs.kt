package numberofgoodleafnodespairs

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun countPairs(root: TreeNode?, distance: Int): Int {
        return iterDfs(distance, root)
    }

    private fun iterDfs(distance: Int, root: TreeNode?): Int {
        var result = 0
        val ret = HashMap<Int, Int>()
        class Frame(
            val step: Int,
            val node: TreeNode?,
            val left: HashMap<Int, Int>?,
            val right: HashMap<Int, Int>?,
            val ret: HashMap<Int, Int>
        )

        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, root, null, null, ret))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            if (frame.step == 1) {
                val node = frame.node ?: continue
                if (node.left == null && node.right == null) {
                    frame.ret[0] = 1
                    continue
                }
                val left = HashMap<Int, Int>()
                val right = HashMap<Int, Int>()
                stk.addLast(Frame(2, null, left, right, frame.ret))
                stk.addLast(Frame(1, node.right, null, null, right))
                stk.addLast(Frame(1, node.left, null, null, left))
            } else {
                val left = frame.left!!
                val right = frame.right!!
                for ((leftD, leftC) in left) {
                    for ((rightD, rightC) in right) {
                        if (leftD + rightD + 2 <= distance) {
                            result += leftC * rightC
                        }
                    }
                }
                for ((leftD, leftC) in left) {
                    frame.ret[leftD + 1] = (frame.ret[leftD + 1] ?: 0) + leftC
                }
                for ((rightD, rightC) in right) {
                    frame.ret[rightD + 1] = (frame.ret[rightD + 1] ?: 0) + rightC
                }
            }
        }
        return result
    }
}
