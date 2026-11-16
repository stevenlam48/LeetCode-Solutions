package validatebinarytreenodes
// Time:  O(n)
// Space: O(n)

class Solution {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val roots = (0 until n).toMutableSet()
        for (i in leftChild) {
            roots.remove(i)
        }
        for (i in rightChild) {
            roots.remove(i)
        }
        if (roots.size != 1) {
            return false
        }
        val root = roots.first()
        val stack = mutableListOf(root)
        val lookup = mutableSetOf(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeAt(stack.lastIndex)
            for (i in intArrayOf(leftChild[node], rightChild[node])) {
                if (i < 0) {
                    continue
                }
                if (!lookup.add(i)) {
                    return false
                }
                stack.add(i)
            }
        }
        return lookup.size == n
    }
}
