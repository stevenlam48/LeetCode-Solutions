package diameterofnarytree

// Time:  O(n)
// Space: O(h)

class Node(var `val`: Int) {
    var children: List<Node> = emptyList()
}

class Solution {
    fun diameter(root: Node): Int = iterDfs(root).diameter

    private data class Result(var diameter: Int = 0, var depth: Int = 0)

    private data class Frame(
        val step: Int,
        val node: Node?,
        val childResult: Result?,
        val result: Result
    )

    private fun iterDfs(root: Node): Result {
        val result = Result()
        val stack = mutableListOf(Frame(1, root, null, result))
        while (stack.isNotEmpty()) {
            val frame = stack.removeAt(stack.lastIndex)
            if (frame.step == 1) {
                val node = frame.node!!
                for (i in node.children.indices.reversed()) {
                    val childResult = Result()
                    stack.add(Frame(2, null, childResult, frame.result))
                    stack.add(Frame(1, node.children[i], null, childResult))
                }
            } else {
                val child = frame.childResult!!
                frame.result.diameter = maxOf(
                    frame.result.diameter,
                    maxOf(child.diameter, frame.result.depth + child.depth + 1)
                )
                frame.result.depth = maxOf(frame.result.depth, child.depth + 1)
            }
        }
        return result
    }
}
