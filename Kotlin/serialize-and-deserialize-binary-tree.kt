package serializeanddeserializebinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Codec {
    fun serialize(root: TreeNode?): String {
        val output = StringBuilder()
        serializeHelper(root, output)
        return output.toString()
    }

    fun deserialize(data: String): TreeNode? {
        val start = intArrayOf(0)
        return deserializeHelper(data, start)
    }

    private fun getNumber(data: String, start: IntArray): Int? {
        var sign = 1
        if (data[start[0]] == '#') {
            start[0] += 2
            return null
        } else if (data[start[0]] == '-') {
            sign = -1
            start[0] += 1
        }
        var num = 0
        while (start[0] < data.length && data[start[0]].isDigit()) {
            num = num * 10 + (data[start[0]] - '0')
            start[0] += 1
        }
        num *= sign
        start[0] += 1
        return num
    }

    private fun serializeHelper(root: TreeNode?, prev: StringBuilder) {
        if (root == null) {
            prev.append("# ")
        } else {
            prev.append(root.`val`).append(" ")
            serializeHelper(root.left, prev)
            serializeHelper(root.right, prev)
        }
    }

    private fun deserializeHelper(data: String, start: IntArray): TreeNode? {
        val num = getNumber(data, start) ?: return null
        val root = TreeNode(num)
        root.left = deserializeHelper(data, start)
        root.right = deserializeHelper(data, start)
        return root
    }
}
