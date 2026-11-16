package nextclosesttime
// Time:  O(1)
// Space: O(1)

class Solution {
    fun nextClosestTime(time: String): String {
        val mins = intArrayOf(600, 60, 10, 1)
        val colon = time.indexOf(':')
        val curr = time.substring(0, colon).toInt() * 60 + time.substring(colon + 1).toInt()
        val result = CharArray(4) { '0' }
        var i = 1
        var d = 0
        while (i <= 1440 && d < 4) {
            var m = (curr + i) % 1440
            d = 0
            while (d < 4) {
                result[d] = '0' + m / mins[d]
                m %= mins[d]
                if (!time.contains(result[d])) {
                    break
                }
                ++d
            }
            ++i
        }
        return "${result.concatToString(0, 2)}:${result.concatToString(2, 4)}"
    }
}
