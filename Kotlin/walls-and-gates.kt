package wallsandgates
// Time:  O(m * n)
// Space: O(g)

class Solution {
    fun wallsAndGates(rooms: Array<IntArray>) {
        val inf = Int.MAX_VALUE
        val queue = ArrayDeque<Pair<Int, Int>>()
        for (i in rooms.indices) {
            for (j in rooms[0].indices) {
                if (rooms[i][j] == 0) {
                    queue.add(i to j)
                }
            }
        }
        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeFirst()
            for (d in arrayOf(
                intArrayOf(i + 1, j),
                intArrayOf(i - 1, j),
                intArrayOf(i, j + 1),
                intArrayOf(i, j - 1)
            )) {
                val row = d[0]
                val column = d[1]
                if (row >= 0 && row < rooms.size &&
                    column >= 0 && column < rooms[0].size &&
                    rooms[row][column] == inf
                ) {
                    rooms[row][column] = rooms[i][j] + 1
                    queue.add(row to column)
                }
            }
        }
    }
}
