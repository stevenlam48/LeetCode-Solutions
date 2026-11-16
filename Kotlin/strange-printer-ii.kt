package strangeprinterii
// Time:  O(c * m * n + e), c is the number of colors
//                        , e is the number of edges in adj, at most O(c^2)
// Space: O(e)

class Solution {
    fun isPrintable(targetGrid: Array<IntArray>): Boolean {
        val boxes = HashMap<Int, IntArray>()
        for (r in targetGrid.indices) {
            for (c in targetGrid[r].indices) {
                val color = targetGrid[r][c]
                val box = boxes.getOrPut(color) { intArrayOf(r, c, r, c) }
                box[0] = minOf(box[0], r)
                box[1] = minOf(box[1], c)
                box[2] = maxOf(box[2], r)
                box[3] = maxOf(box[3], c)
            }
        }
        val adj = HashMap<Int, MutableSet<Int>>()
        for ((color, box) in boxes) {
            for (r in box[0]..box[2]) {
                for (c in box[1]..box[3]) {
                    if (targetGrid[r][c] != color) {
                        adj.getOrPut(color) { HashSet() }.add(targetGrid[r][c])
                    }
                }
            }
        }
        val lookup = HashMap<Int, State>()
        for (color in boxes.keys) {
            if (color in lookup) {
                continue
            }
            if (hasCycle(adj, color, lookup)) {
                return false
            }
        }
        return true
    }

    private enum class State {
        VISITING,
        VISITED
    }

    private fun hasCycle(
        adj: HashMap<Int, MutableSet<Int>>,
        color: Int,
        lookup: HashMap<Int, State>
    ): Boolean {
        val stack = ArrayDeque<Pair<Int, Int>>()
        stack.addLast(1 to color)
        while (stack.isNotEmpty()) {
            val (step, currentColor) = stack.removeLast()
            if (step == 1) {
                lookup[currentColor] = State.VISITING
                stack.addLast(2 to currentColor)
                for (newColor in adj[currentColor].orEmpty()) {
                    if (newColor in lookup) {
                        if (lookup[newColor] == State.VISITED) {
                            continue
                        }
                        return true
                    }
                    stack.addLast(1 to newColor)
                }
            } else {
                lookup[currentColor] = State.VISITED
            }
        }
        return false
    }
}
