package serializeanddeserializenarytree

// Time:  O(n)
// Space: O(h)

class Node(var `val`: Int, var children: MutableList<Node> = mutableListOf())

class Codec {
    fun serialize(root: Node?): String {
        val out = StringBuilder()
        serializeHelper(root, out)
        return out.toString()
    }

    fun deserialize(data: String): Node? {
        if (data.isEmpty()) {
            return null
        }
        val start = intArrayOf(0)
        return deserializeHelper(data, start)
    }

    private fun serializeHelper(root: Node?, out: StringBuilder) {
        if (root == null) {
            return
        }
        out.append(root.`val`).append(' ')
        for (child in root.children) {
            serializeHelper(child, out)
        }
        out.append("# ")
    }

    private fun deserializeHelper(data: String, start: IntArray): Node? {
        val num = getNumber(data, start) ?: return null
        val root = Node(num)
        while (true) {
            val child = deserializeHelper(data, start) ?: break
            root.children.add(child)
        }
        return root
    }

    private fun getNumber(data: String, start: IntArray): Int? {
        var sign = 1
        if (data[start[0]] == '#') {
            start[0] += 2
            return null
        } else if (data[start[0]] == '-') {
            sign = -1
            ++start[0]
        }
        var num = 0
        while (data[start[0]].isDigit()) {
            num = num * 10 + (data[start[0]] - '0')
            ++start[0]
        }
        num *= sign
        ++start[0]
        return num
    }
}
