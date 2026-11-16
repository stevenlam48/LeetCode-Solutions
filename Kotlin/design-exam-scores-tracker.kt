package designexamscorestracker

// Time:  ctor:        O(1)
//        record:      O(1)
//        totalScore: O(logn)
// Space: O(n)
class ExamTracker {
    private val times = ArrayList<Int>()
    private val prefix = arrayListOf(0L)

    fun record(time: Int, score: Int) {
        times.add(time)
        prefix.add(prefix.last() + score)
    }

    fun totalScore(startTime: Int, endTime: Int): Long {
        val i = lowerBound(startTime)
        val j = upperBound(endTime) - 1
        return prefix[j + 1] - prefix[i]
    }

    private fun lowerBound(target: Int): Int {
        var left = 0
        var right = times.size
        while (left < right) {
            val middle = left + (right - left) / 2
            if (times[middle] < target) {
                left = middle + 1
            } else {
                right = middle
            }
        }
        return left
    }

    private fun upperBound(target: Int): Int {
        var left = 0
        var right = times.size
        while (left < right) {
            val middle = left + (right - left) / 2
            if (times[middle] <= target) {
                left = middle + 1
            } else {
                right = middle
            }
        }
        return left
    }
}
