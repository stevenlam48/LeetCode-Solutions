package analyzeuserwebsitevisitpattern

// Time:  O(n^3)
// Space: O(n^3)

class Solution {
    private data class Visit(val timestamp: Int, val username: String, val website: String)

    fun mostVisitedPattern(
        username: List<String>,
        timestamp: List<Int>,
        website: List<String>
    ): List<String> {
        val visits = ArrayList<Visit>(username.size)
        for (i in username.indices) {
            visits.add(Visit(timestamp[i], username[i], website[i]))
        }
        visits.sortWith(compareBy({ it.timestamp }, { it.username }, { it.website }))
        val users = LinkedHashMap<String, MutableList<String>>()
        for (v in visits) {
            users.getOrPut(v.username) { mutableListOf() }.add(v.website)
        }

        var result = emptyList<String>()
        val count = HashMap<List<String>, Int>()
        for (webs in users.values) {
            val lookup = HashSet<List<String>>()
            for (i in 0 until webs.size - 2) {
                for (j in i + 1 until webs.size - 1) {
                    for (k in j + 1 until webs.size) {
                        val pattern = listOf(webs[i], webs[j], webs[k])
                        if (lookup.contains(pattern)) {
                            continue
                        }
                        lookup.add(pattern)
                        count[pattern] = (count[pattern] ?: 0) + 1
                        if (result.isEmpty() ||
                            count[pattern]!! > count[result]!! ||
                            (count[pattern] == count[result] && lessThan(pattern, result))
                        ) {
                            result = pattern
                        }
                    }
                }
            }
        }
        return result
    }

    private fun lessThan(a: List<String>, b: List<String>): Boolean {
        for (i in a.indices) {
            val cmp = a[i].compareTo(b[i])
            if (cmp != 0) {
                return cmp < 0
            }
        }
        return false
    }
}
