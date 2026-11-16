package serializeanddeserializebst

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Codec {
    fun serialize(root: TreeNode?): String {
        val data = StringBuilder()
        serializeHelper(root, data)
        return data.toString()
    }

    fun deserialize(data: String): TreeNode? {
        val i = intArrayOf(0)
        return deserializeHelper(Int.MIN_VALUE, Int.MAX_VALUE, data, i)
    }

    private fun serializeHelper(node: TreeNode?, data: StringBuilder) {
        if (node != null) {
            data.append(node.`val`).append(" ")
            serializeHelper(node.left, data)
            serializeHelper(node.right, data)
        }
    }

    private fun deserializeHelper(minVal: Int, maxVal: Int, data: String, i: IntArray): TreeNode? {
        if (i[0] >= data.length) {
            return null
        }
        var j = data.indexOf(' ', i[0])
        if (j == -1) {
            j = data.length
        }
        val v = data.substring(i[0], j).toInt()
        if (minVal < v && v < maxVal) {
            val node = TreeNode(v)
            i[0] = j + 1
            node.left = deserializeHelper(minVal, v, data, i)
            node.right = deserializeHelper(v, maxVal, data, i)
            return node
        }
        return null
    }
}
