package sequentiallyordinalranktracker

// Time:  add: O(logn)
//        get: O(logn)
// Space: O(n)

class SORTracker {
    private val lookup = java.util.TreeSet<Pair<Int, String>>(compareBy({ it.first }, { it.second }))
    private var cursor: Pair<Int, String>? = null

    fun add(name: String, score: Int) {
        val entry = Pair(-score, name)
        lookup.add(entry)
        val c = cursor
        if (c == null) {
            cursor = lookup.last()
        } else if (entry.first < c.first || (entry.first == c.first && entry.second < c.second)) {
            cursor = lookup.lower(c)
        }
    }

    fun get(): String {
        val entry = cursor!!
        cursor = lookup.higher(entry)
        return entry.second
    }
}
