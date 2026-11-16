package onlineelection

// Time:  ctor: O(n)
//        q:    O(logn)
// Space: O(n)

class TopVotedCandidate(persons: IntArray, times: IntArray) {
    private val lookup = mutableListOf<Pair<Int, Int>>()

    init {
        var lead = -1
        val count = HashMap<Int, Int>()
        for (i in persons.indices) {
            val c = (count[persons[i]] ?: 0) + 1
            count[persons[i]] = c
            if (c >= (count[lead] ?: 0)) {
                lead = persons[i]
                lookup.add(times[i] to persons[i])
            }
        }
    }

    fun q(t: Int): Int {
        var lo = 0
        var hi = lookup.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (lookup[mid].first <= t) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lookup[lo - 1].second
    }
}
