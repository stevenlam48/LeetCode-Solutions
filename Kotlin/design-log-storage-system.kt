package designlogstoragesystem

// Time:  put:      O(logn), n is the size of the total logs
//        retrieve: O(logn + d), d is the size of the found logs
// Space: O(n)
import java.util.TreeMap

class LogSystem {
    private val granularity = hashMapOf(
        "Year" to 4,
        "Month" to 7,
        "Day" to 10,
        "Hour" to 13,
        "Minute" to 16,
        "Second" to 19
    )
    private val startFilter = "0001:01:01:00:00:00"
    private val endFilter = "9999:12:31:23:59:59"
    private val lookup = TreeMap<String, MutableList<Int>>()

    fun put(id: Int, timestamp: String) {
        lookup.getOrPut(timestamp) { mutableListOf() }.add(id)
    }

    fun retrieve(s: String, e: String, gra: String): List<Int> {
        val length = granularity.getValue(gra)
        val start = s.substring(0, length) + startFilter.substring(length)
        val end = e.substring(0, length) + endFilter.substring(length)
        val result = mutableListOf<Int>()
        for (ids in lookup.subMap(start, true, end, true).values) {
            result.addAll(ids)
        }
        return result
    }
}
