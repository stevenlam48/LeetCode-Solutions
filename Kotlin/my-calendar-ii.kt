package mycalendarii

// Time:  O(n^2)
// Space: O(n)

class MyCalendarTwo {
    private val overlaps = mutableListOf<IntArray>()
    private val calendar = mutableListOf<IntArray>()

    fun book(start: Int, end: Int): Boolean {
        for (p in overlaps) {
            if (start < p[1] && end > p[0]) {
                return false
            }
        }
        for (p in calendar) {
            if (start < p[1] && end > p[0]) {
                overlaps.add(intArrayOf(maxOf(start, p[0]), minOf(end, p[1])))
            }
        }
        calendar.add(intArrayOf(start, end))
        return true
    }
}
