package timebasedkeyvaluestore
// Time:  set: O(1)
//        get: O(logn)
// Space: O(n)

class TimeMap {
    private val lookup = HashMap<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        lookup.getOrPut(key) { mutableListOf() }.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val values = lookup[key] ?: return ""
        var left = 0
        var right = values.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (values[mid].first < timestamp + 1) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return if (left != 0) values[left - 1].second else ""
    }
}
