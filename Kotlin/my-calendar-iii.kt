package mycalendariii

// Time:  O(nlogn) ~ O(n^2)
// Space: O(n)

class MyCalendarThree {
    private val events = java.util.TreeMap<Int, Int>()
    private var count = 0

    init {
        events[-1] = 0
    }

    fun book(start: Int, end: Int): Int {
        if (!events.containsKey(start)) {
            events[start] = events.floorEntry(start)!!.value
        }
        if (!events.containsKey(end)) {
            events[end] = events.floorEntry(end)!!.value
        }
        for (key in events.subMap(start, true, end, false).keys.toList()) {
            val value = events[key]!! + 1
            events[key] = value
            count = maxOf(count, value)
        }
        return count
    }
}
