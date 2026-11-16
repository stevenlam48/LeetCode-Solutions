package numberofrecentcalls

// Time:  O(1) on average
// Space: O(w), w means the size of the last milliseconds

class RecentCounter() {
    private val q = java.util.ArrayDeque<Int>()

    fun ping(t: Int): Int {
        q.addLast(t)
        while (q.first() < t - 3000) {
            q.removeFirst()
        }
        return q.size
    }
}
