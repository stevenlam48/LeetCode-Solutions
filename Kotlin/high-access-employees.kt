package highaccessemployees
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findHighAccessEmployees(accessTimes: List<List<String>>): List<String> {
        fun toMinute(s: String): Int {
            return s.substring(0, 2).toInt() * 60 + s.substring(2).toInt()
        }

        val lookup = HashMap<String, MutableList<Int>>()
        for (x in accessTimes) {
            lookup.getOrPut(x[0]) { mutableListOf() }.add(toMinute(x[1]))
        }
        val result = mutableListOf<String>()
        for ((x, ts) in lookup) {
            ts.sort()
            for (i in 0 until ts.size - LIMIT_COUNT) {
                if (ts[i] + LIMIT_MINUTE > ts[i + LIMIT_COUNT]) {
                    result.add(x)
                    break
                }
            }
        }
        return result
    }

    companion object {
        private const val LIMIT_COUNT = 2
        private const val LIMIT_MINUTE = 60
    }
}
