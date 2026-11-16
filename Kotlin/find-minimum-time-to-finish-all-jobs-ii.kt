package findminimumtimetofinishalljobsii

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minimumTime(jobs: IntArray, workers: IntArray): Int {
        val sortedJobs = jobs.sorted()
        val sortedWorkers = workers.sorted()
        var result = 0
        for (i in sortedJobs.indices) {
            result = maxOf(result, ceilDivide(sortedJobs[i], sortedWorkers[i]))
        }
        return result
    }

    private fun ceilDivide(a: Int, b: Int): Int = (a + (b - 1)) / b
}
