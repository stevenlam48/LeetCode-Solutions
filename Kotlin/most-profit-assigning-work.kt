package mostprofitassigningwork
// Time:  O(mlogm + nlogn), m is the number of workers,
//                        , n is the number of jobs
// Space: O(n)

class Solution {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val jobs = mutableListOf<Pair<Int, Int>>()
        for (i in profit.indices) {
            jobs.add(difficulty[i] to profit[i])
        }
        jobs.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        worker.sort()

        var result = 0
        var i = 0
        var maxProfit = 0
        for (ability in worker) {
            while (i < profit.size && jobs[i].first <= ability) {
                maxProfit = maxOf(maxProfit, jobs[i].second)
                i++
            }
            result += maxProfit
        }
        return result
    }
}
