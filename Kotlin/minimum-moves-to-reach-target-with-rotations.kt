package minimummovestoreachtargetwithrotations

// Time:  O(n)
// Space: O(n)

class Solution {
    private data class State(val r: Int, val c: Int, val isVertical: Boolean)

    fun minimumMoves(grid: Array<IntArray>): Int {
        var level = 0
        var queue = mutableListOf(State(0, 0, false))
        val lookup = HashSet<State>()
        while (queue.isNotEmpty()) {
            val nextQueue = mutableListOf<State>()
            for ((r, c, isVertical) in queue) {
                val state = State(r, c, isVertical)
                if (state in lookup) {
                    continue
                }
                if (r == grid.size - 1 && c == grid.size - 2 && !isVertical) {
                    return level
                }
                lookup.add(state)
                if (!isVertical) {
                    if (c + 2 != grid[0].size && grid[r][c + 2] == 0) {
                        nextQueue.add(State(r, c + 1, false))
                    }
                    if (r + 1 != grid.size &&
                        grid[r + 1][c] == 0 && grid[r + 1][c + 1] == 0
                    ) {
                        nextQueue.add(State(r + 1, c, false))
                        nextQueue.add(State(r, c, true))
                    }
                } else {
                    if (r + 2 != grid.size && grid[r + 2][c] == 0) {
                        nextQueue.add(State(r + 1, c, true))
                    }
                    if (c + 1 != grid[0].size &&
                        grid[r][c + 1] == 0 && grid[r + 1][c + 1] == 0
                    ) {
                        nextQueue.add(State(r, c + 1, true))
                        nextQueue.add(State(r, c, false))
                    }
                }
            }
            queue = nextQueue
            ++level
        }
        return -1
    }
}
