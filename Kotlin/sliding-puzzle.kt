package slidingpuzzle

// Time:  O((m * n) * (m * n)!)
// Space: O((m * n) * (m * n)!)

class Solution {
    fun slidingPuzzle(board: Array<IntArray>): Int {
        val R = board.size
        val C = board[0].size
        val begin = ArrayList<Int>()
        val end = ArrayList<Int>()
        val expected = HashMap<Int, Pair<Int, Int>>()
        var zeroIdx = 0
        for (i in 0 until R) {
            for (j in 0 until C) {
                val v = (C * i + j + 1) % (R * C)
                expected[v] = Pair(i, j)
                if (board[i][j] == 0) {
                    zeroIdx = begin.size
                }
                begin.add(board[i][j])
                end.add(v)
            }
        }

        var minSteps = heuristicEstimate(begin, R, C, expected)
        val lookup = HashSet<List<Int>>()
        var closer = ArrayDeque<Pair<Int, List<Int>>>()
        var detour = ArrayDeque<Pair<Int, List<Int>>>()
        closer.addLast(Pair(zeroIdx, begin))
        while (true) {
            if (closer.isEmpty()) {
                if (detour.isEmpty()) {
                    return -1
                }
                minSteps += 2
                val tmp = closer
                closer = detour
                detour = tmp
            }
            val (zero, b) = closer.removeLast()
            if (b == end) {
                return minSteps
            }
            if (!lookup.contains(b)) {
                lookup.add(b)
                val r = zero / C
                val c = zero % C
                for ((dr, dc) in directions) {
                    val i = r + dr
                    val j = c + dc
                    if (i in 0 until R && j in 0 until C) {
                        val newZero = C * i + j
                        val newBoard = b.toMutableList()
                        val tmp = newBoard[zero]
                        newBoard[zero] = newBoard[newZero]
                        newBoard[newZero] = tmp
                        val (r2, c2) = expected[b[newZero]]!!
                        val r1 = zero / C
                        val c1 = zero % C
                        val r0 = newZero / C
                        val c0 = newZero % C
                        val isCloser = dot(r1 - r0, c1 - c0, r2 - r0, c2 - c0) > 0
                        if (isCloser) {
                            closer.addLast(Pair(newZero, newBoard))
                        } else {
                            detour.addLast(Pair(newZero, newBoard))
                        }
                    }
                }
            }
        }
    }

    private fun heuristicEstimate(
        board: List<Int>,
        R: Int,
        C: Int,
        expected: Map<Int, Pair<Int, Int>>
    ): Int {
        var result = 0
        for (i in 0 until R) {
            for (j in 0 until C) {
                val v = board[C * i + j]
                if (v == 0) {
                    continue
                }
                val (r, c) = expected[v]!!
                result += Math.abs(r - i) + Math.abs(c - j)
            }
        }
        return result
    }

    private fun dot(a1: Int, a2: Int, b1: Int, b2: Int): Int = a1 * b1 + a2 * b2

    private companion object {
        val directions = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
    }
}
