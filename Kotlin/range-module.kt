package rangemodule

// Time:  addRange:    O(n)
//        removeRange: O(n)
//        queryRange:  O(logn)
// Space: O(n)

class RangeModule {
    private var intervals = mutableListOf<IntArray>()

    // Time:  O(n)
    fun addRange(left0: Int, right0: Int) {
        var left = left0
        var right = right0
        val tmp = mutableListOf<IntArray>()
        var i = 0
        while (i < intervals.size) {
            val interval = intervals[i]
            if (right < interval[0]) {
                tmp.add(intArrayOf(left, right))
                break
            } else if (interval[1] < left) {
                tmp.add(interval)
            } else {
                left = minOf(left, interval[0])
                right = maxOf(right, interval[1])
            }
            ++i
        }
        if (i == intervals.size) {
            tmp.add(intArrayOf(left, right))
        }
        while (i < intervals.size) {
            tmp.add(intervals[i++])
        }
        intervals = tmp
    }

    // Time:  O(logn)
    fun queryRange(left: Int, right: Int): Boolean {
        var lo = 0
        var hi = intervals.size
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (intervals[mid][1] < left) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo != intervals.size && intervals[lo][0] <= left && intervals[lo][1] >= right
    }

    // Time:  O(n)
    fun removeRange(left: Int, right: Int) {
        val tmp = mutableListOf<IntArray>()
        for (interval in intervals) {
            if (interval[1] <= left || interval[0] >= right) {
                tmp.add(interval)
            } else {
                if (interval[0] < left) {
                    tmp.add(intArrayOf(interval[0], left))
                }
                if (right < interval[1]) {
                    tmp.add(intArrayOf(right, interval[1]))
                }
            }
        }
        intervals = tmp
    }
}
