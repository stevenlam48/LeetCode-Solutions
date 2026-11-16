package numberofvalidmovecombinationsonchessboard

// Time:  O(n^p) = O(1), n is the max number of possible moves for each piece, and n is at most 29
//                     , p is the number of pieces, and p is at most 4
// Space: O(1)

class Solution {
    private val directions = mapOf(
        "rook" to listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0),
        "bishop" to listOf(1 to 1, 1 to -1, -1 to 1, -1 to -1),
        "queen" to listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0, 1 to 1, 1 to -1, -1 to 1, -1 to -1)
    )

    fun countCombinations(pieces: List<String>, positions: Array<IntArray>): Int {
        val lookup = Array(8) { IntArray(8) }
        return backtracking(pieces, positions, 0, lookup)
    }

    private fun backtracking(pieces: List<String>, positions: Array<IntArray>, i: Int, lookup: Array<IntArray>): Int {
        val allMask = (1 shl 7) - 1

        if (i == pieces.size) {
            return 1
        }
        var result = 0
        val r = positions[i][0] - 1
        val c = positions[i][1] - 1
        val mask = allMask
        if ((lookup[r][c] and mask) == 0) {
            lookup[r][c] += mask
            result += backtracking(pieces, positions, i + 1, lookup)
            lookup[r][c] -= mask
        }
        for ((dr, dc) in directions[pieces[i]]!!) {
            var bit = 1
            var nr = r + dr
            var nc = c + dc
            var m = allMask
            while (0 <= nr && nr < 8 && 0 <= nc && nc < 8 && (lookup[nr][nc] and bit) == 0) {
                lookup[nr][nc] += bit
                m -= bit
                if ((lookup[nr][nc] and m) == 0) {
                    lookup[nr][nc] += m
                    result += backtracking(pieces, positions, i + 1, lookup)
                    lookup[nr][nc] -= m
                }
                bit = bit shl 1
                nr += dr
                nc += dc
            }
            while ((bit shr 1) != 0) {
                bit = bit shr 1
                nr -= dr
                nc -= dc
                lookup[nr][nc] -= bit
            }
        }
        return result
    }
}
