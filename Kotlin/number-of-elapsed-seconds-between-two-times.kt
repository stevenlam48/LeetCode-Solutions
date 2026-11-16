package numberofelapsedsecondsbetweentwotimes

// Time:  O(1)
// Space: O(1)

// string
class Solution {
    fun secondsBetweenTimes(startTime: String, endTime: String): Int {
        fun toSeconds(x: String): Int {
            val h = x.substring(0, 2).toInt()
            val m = x.substring(3, 5).toInt()
            val s = x.substring(6, 8).toInt()
            return h * 60 * 60 + m * 60 + s
        }

        return toSeconds(endTime) - toSeconds(startTime)
    }
}
