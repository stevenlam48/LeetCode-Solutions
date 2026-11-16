package mycalendari

// Time:  O(nlogn)
// Space: O(n)

class MyCalendar {
    private val books = java.util.TreeMap<Int, Int>()

    fun book(s: Int, e: Int): Boolean {
        val next = books.ceilingEntry(s)
        if (next != null && next.key < e) {
            return false
        }
        val prev = books.lowerEntry(s)
        if (prev != null && s < prev.value) {
            return false
        }
        books[s] = e
        return true
    }
}
