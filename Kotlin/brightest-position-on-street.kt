package brightestpositiononstreet

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun brightestPosition(lights: Array<IntArray>): Int {
        val count = HashMap<Int, Int>()
        for (light in lights) {
            count[light[0] - light[1]] = (count[light[0] - light[1]] ?: 0) + 1
            count[light[0] + light[1] + 1] = (count[light[0] + light[1] + 1] ?: 0) - 1
        }
        val points = count.entries.sortedBy { it.key }
        var result = Int.MIN_VALUE
        var maxCnt = 0
        var cnt = 0
        for ((i, c) in points) {
            cnt += c
            if (cnt > maxCnt) {
                maxCnt = cnt
                result = i
            }
        }
        return result
    }
}
