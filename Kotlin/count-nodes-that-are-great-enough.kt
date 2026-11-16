package countnodesthataregreatenough

import common.TreeNode

// Time:  O(k * h)
// Space: O(k + h)

// merge sort
class Solution {
    fun countGreatEnoughNodes(root: TreeNode?, k: Int): Int {
        var result = 0

        fun mergeAtMostK(a: List<Int>, b: List<Int>): MutableList<Int> {
            val res = ArrayList<Int>(k)
            var i = 0
            var j = 0
            while (i < a.size || j < b.size) {
                if (j == b.size || (i < a.size && a[i] < b[j])) {
                    res.add(a[i++])
                } else {
                    res.add(b[j++])
                }
                if (res.size == k) {
                    break
                }
            }
            return res
        }

        fun mergeSort(node: TreeNode?): MutableList<Int> {
            if (node == null) {
                return mutableListOf()
            }
            val left = mergeSort(node.left)
            val right = mergeSort(node.right)
            val smallestK = mergeAtMostK(left, right)
            var i = 0
            while (i < smallestK.size && smallestK[i] < node.`val`) {
                ++i
            }
            if (i == k) {
                ++result
            } else {
                smallestK.add(i, node.`val`)
                if (smallestK.size == k + 1) {
                    smallestK.removeAt(smallestK.size - 1)
                }
            }
            return smallestK
        }

        mergeSort(root)
        return result
    }
}
