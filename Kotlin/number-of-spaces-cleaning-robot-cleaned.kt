package numberofspacescleaningrobotcleaned

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun numberOfCleanRooms(room: Array<IntArray>): Int {
        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )
        var result = 0
        var r = 0
        var c = 0
        var d = 0
        while (room[r][c] and (1 shl (d + 1)) == 0) {
            if ((room[r][c] shr 1) == 0) {
                ++result
            }
            room[r][c] = room[r][c] or (1 shl (d + 1))
            val dr = directions[d][0]
            val dc = directions[d][1]
            val nr = r + dr
            val nc = c + dc
            if (nr in 0 until room.size && nc in 0 until room[0].size && room[nr][nc] and 1 == 0) {
                r = nr
                c = nc
            } else {
                d = (d + 1) % 4
            }
        }
        return result
    }
}
