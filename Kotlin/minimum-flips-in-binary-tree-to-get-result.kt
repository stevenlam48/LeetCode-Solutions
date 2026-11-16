package minimumflipsinbinarytreetogetresult

import common.TreeNode

// Time:  O(n)
// Space: O(h)

// tree dp with stack
class Solution {
    fun minimumFlips(root: TreeNode?, result: Boolean): Int {
        val INF = Int.MAX_VALUE
        val op = { v: Int, x: Int, y: Int ->
            when (v) {
                2 -> x or y
                3 -> x and y
                4 -> x xor y
                5 -> if (x != -1) (x xor 1) else (y xor 1)
                else -> 0
            }
        }

        val ret = HashMap<Int, Int>()
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, root, null, null, ret))
        while (stk.isNotEmpty()) {
            val (step, node, ret1, ret2, curRet) = stk.removeLast()
            if (step == 1) {
                if (node == null) {
                    curRet[-1] = 0
                    continue
                }
                if (node.left == null && node.right == null) {
                    curRet[1] = node.`val` xor 1
                    curRet[0] = node.`val` xor 0
                    continue
                }
                val left = HashMap<Int, Int>()
                val right = HashMap<Int, Int>()
                stk.addLast(Frame(2, node, left, right, curRet))
                stk.addLast(Frame(1, node.right, null, null, right))
                stk.addLast(Frame(1, node.left, null, null, left))
            } else {
                for ((k1, v1) in ret1!!) {
                    for ((k2, v2) in ret2!!) {
                        val nk = op(node!!.`val`, k1, k2)
                        curRet[nk] = minOf(curRet.getOrDefault(nk, INF), v1 + v2)
                    }
                }
            }
        }
        return ret[if (result) 1 else 0]!!
    }

    private data class Frame(
        val step: Int,
        val node: TreeNode?,
        val ret1: HashMap<Int, Int>?,
        val ret2: HashMap<Int, Int>?,
        val ret: HashMap<Int, Int>,
    )
}
