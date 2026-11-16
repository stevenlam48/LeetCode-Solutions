package maximizeprofitfromtaskassignment

// Time:  O(n + tlogt)
// Space: O(n)

class Solution {
    fun maxProfit(workers: IntArray, tasks: Array<IntArray>): Long {
        val cnt = HashMap<Int, Int>()
        for (x in workers) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        tasks.sortWith(compareByDescending { it[1] })
        var result = 0L
        var k = 1
        for (t in tasks) {
            val count = cnt[t[0]] ?: 0
            if (count > 0) {
                cnt[t[0]] = count - 1
                result += t[1]
            } else if (k > 0) {
                --k
                result += t[1]
            }
        }
        return result
    }
}
