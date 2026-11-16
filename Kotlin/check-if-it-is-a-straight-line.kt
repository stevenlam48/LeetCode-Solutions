package checkifitisastraightline

// Time:  O(n)
// Space: O(1)
class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val i = coordinates[0]
        val j = coordinates[1]
        for (index in 2 until coordinates.size) {
            val k = coordinates[index]
            if (i[0] * j[1] - j[0] * i[1] +
                j[0] * k[1] - k[0] * j[1] +
                k[0] * i[1] - i[0] * k[1] != 0
            ) {
                return false
            }
        }
        return true
    }
}
