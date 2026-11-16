package escapealargemaze

// Time:  O(n^2), n is the number of blocked
// Space: O(n)
class Solution {
    fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
        val blocks = HashSet<Long>()
        for (block in blocked) {
            blocks.add(key(block[0], block[1]))
        }
        return bfs(blocks, source[0], source[1], target[0], target[1]) &&
            bfs(blocks, target[0], target[1], source[0], source[1])
    }

    private fun key(r: Int, c: Int): Long = r.toLong() * 1000000L + c

    private fun bfs(blocks: Set<Long>, sr: Int, sc: Int, tr: Int, tc: Int): Boolean {
        val R = 1000000
        val C = 1000000
        val directions = arrayOf(
            intArrayOf(0, -1), intArrayOf(0, 1),
            intArrayOf(-1, 0), intArrayOf(1, 0)
        )

        val maxAreaSurroundedByBlocks = blocks.size.toLong() * (blocks.size - 1) / 2
        val lookup = HashSet<Long>()
        lookup.add(key(sr, sc))
        if (lookup.size > maxAreaSurroundedByBlocks) {
            return true
        }
        val q = ArrayDeque<IntArray>()
        q.add(intArrayOf(sr, sc))
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            if (cur[0] == tr && cur[1] == tc) {
                return true
            }
            for (dir in directions) {
                val nr = cur[0] + dir[0]
                val nc = cur[1] + dir[1]

                if (!((0 <= nr && nr < R) &&
                        (0 <= nc && nc < C) &&
                        !lookup.contains(key(nr, nc)) &&
                        !blocks.contains(key(nr, nc)))
                ) {
                    continue
                }
                lookup.add(key(nr, nc))
                if (lookup.size > maxAreaSurroundedByBlocks) {
                    return true
                }
                q.add(intArrayOf(nr, nc))
            }
        }
        return false
    }
}
