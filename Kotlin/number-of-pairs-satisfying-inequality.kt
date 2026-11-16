package numberofpairssatisfyinginequality

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, diff: Int): Long {
        var root: Node? = null
        var result = 0L
        for (i in nums1.indices) {
            val value = nums1[i] - nums2[i]
            result += rank(root, value + diff + 1, 0)
            root = insert(root, value, i)
        }
        return result
    }

    private class Node(val value: Int, val index: Int) {
        var left: Node? = null
        var right: Node? = null
        var height = 1
        var size = 1
    }

    private fun rank(root: Node?, value: Int, index: Int): Int {
        if (root == null) {
            return 0
        }
        return if (less(root.value, root.index, value, index)) {
            size(root.left) + 1 + rank(root.right, value, index)
        } else {
            rank(root.left, value, index)
        }
    }

    private fun insert(root: Node?, value: Int, index: Int): Node {
        if (root == null) {
            return Node(value, index)
        }
        if (less(value, index, root.value, root.index)) {
            root.left = insert(root.left, value, index)
        } else {
            root.right = insert(root.right, value, index)
        }
        update(root)
        return balance(root)
    }

    private fun balance(root: Node): Node {
        val factor = height(root.left) - height(root.right)
        if (factor > 1) {
            if (height(root.left!!.left) < height(root.left!!.right)) {
                root.left = rotateLeft(root.left!!)
            }
            return rotateRight(root)
        }
        if (factor < -1) {
            if (height(root.right!!.right) < height(root.right!!.left)) {
                root.right = rotateRight(root.right!!)
            }
            return rotateLeft(root)
        }
        return root
    }

    private fun rotateLeft(root: Node): Node {
        val newRoot = root.right!!
        root.right = newRoot.left
        newRoot.left = root
        update(root)
        update(newRoot)
        return newRoot
    }

    private fun rotateRight(root: Node): Node {
        val newRoot = root.left!!
        root.left = newRoot.right
        newRoot.right = root
        update(root)
        update(newRoot)
        return newRoot
    }

    private fun update(root: Node) {
        root.height = maxOf(height(root.left), height(root.right)) + 1
        root.size = size(root.left) + size(root.right) + 1
    }

    private fun height(root: Node?): Int = root?.height ?: 0

    private fun size(root: Node?): Int = root?.size ?: 0

    private fun less(value1: Int, index1: Int, value2: Int, index2: Int): Boolean {
        return value1 < value2 || (value1 == value2 && index1 < index2)
    }
}
