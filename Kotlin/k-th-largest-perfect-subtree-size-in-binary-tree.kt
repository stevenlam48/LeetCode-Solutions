package kthlargestperfectsubtreesizeinbinarytree
// Time:  O(n)
// Space: O(n)

import common.TreeNode

class Solution {
    fun kthLargestPerfectSubtree(root: TreeNode?, k: Int): Int {
        val result = mutableListOf<Int>()
        val rootRet = IntArray(1)
        val stk = mutableListOf(Frame(1, root, null, rootRet, 0))
        while (stk.isNotEmpty()) {
            val (step, curr, newRet, ret, retIndex) = stk.removeAt(stk.lastIndex)
            if (step == 1) {
                if (curr == null) {
                    ret[retIndex] = 0
                    result.add(ret[retIndex])
                    continue
                }
                val childrenRet = IntArray(2)
                stk.add(Frame(2, null, childrenRet, ret, retIndex))
                stk.add(Frame(1, curr.right, null, childrenRet, 1))
                stk.add(Frame(1, curr.left, null, childrenRet, 0))
            } else if (step == 2) {
                ret[retIndex] = if (newRet!![0] == newRet[1] && newRet[1] != -1) {
                    newRet[0] + newRet[1] + 1
                } else {
                    -1
                }
                result.add(ret[retIndex])
            }
        }
        if (k - 1 >= result.size) {
            return -1
        }
        result.sortDescending()
        return if (result[k - 1] != 0) result[k - 1] else -1
    }

    private data class Frame(
        val step: Int,
        val curr: TreeNode?,
        val newRet: IntArray?,
        val ret: IntArray,
        val retIndex: Int
    )
}
