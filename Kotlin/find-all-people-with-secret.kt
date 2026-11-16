package findallpeoplewithsecret

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
        meetings.sortBy { it[2] }
        val result = hashSetOf(0, firstPerson)
        val adj = HashMap<Int, MutableList<Int>>()
        for (i in meetings.indices) {
            val x = meetings[i][0]
            val y = meetings[i][1]
            adj.getOrPut(x) { ArrayList() }.add(y)
            adj.getOrPut(y) { ArrayList() }.add(x)
            if (i + 1 != meetings.size && meetings[i + 1][2] == meetings[i][2]) {
                continue
            }
            var queue = adj.keys.filterTo(ArrayList()) { it in result }
            while (queue.isNotEmpty()) {
                val newQueue = ArrayList<Int>()
                for (u in queue) {
                    for (v in adj[u].orEmpty()) {
                        if (v in result) {
                            continue
                        }
                        result.add(v)
                        newQueue.add(v)
                    }
                }
                queue = newQueue
            }
            adj.clear()
        }
        return result.toList()
    }
}
