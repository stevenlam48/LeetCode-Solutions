package maximumnumberofballsinabox

// Time:  O(nlogm)
// Space: O(logm)

class Solution {
    fun countBalls(lowLimit: Int, highLimit: Int): Int {
        val count = HashMap<Int, Int>()
        for (i in lowLimit..highLimit) {
            var total = 0
            var d = i
            while (d != 0) {
                total += d % 10
                d /= 10
            }
            count[total] = (count[total] ?: 0) + 1
        }
        return count.values.max()
    }
}
