package maximumbuildingheight

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
        val sorted = ArrayList<IntArray>(restrictions.size + 2)
        for (restriction in restrictions) {
            sorted.add(intArrayOf(restriction[0], restriction[1]))
        }
        sorted.add(intArrayOf(1, 0))
        sorted.add(intArrayOf(n, n - 1))
        sorted.sortWith(compareBy({ it[0] }, { it[1] }))
        for (i in sorted.size - 2 downTo 0) {
            sorted[i][1] = minOf(
                sorted[i][1],
                sorted[i + 1][1] + (sorted[i + 1][0] - sorted[i][0])
            )
        }
        var result = 0
        for (i in 1 until sorted.size) {
            sorted[i][1] = minOf(
                sorted[i][1],
                sorted[i - 1][1] + (sorted[i][0] - sorted[i - 1][0])
            )
            val left = sorted[i - 1][0]
            val h1 = sorted[i - 1][1]
            val right = sorted[i][0]
            val h2 = sorted[i][1]
            result = maxOf(result, maxOf(h1, h2) + ((right - left) - kotlin.math.abs(h1 - h2)) / 2)
        }
        return result
    }
}
