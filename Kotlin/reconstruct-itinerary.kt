package reconstructitinerary

// Time:  O(|V| + |E|log|V|)
// Space: O(|V| + |E|)

class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val origin = "JFK"
        val adj = HashMap<String, MutableList<String>>()
        for (ticket in tickets) {
            adj.getOrPut(ticket[0]) { ArrayList() }.add(ticket[1])
        }
        for (v in adj.values) {
            v.sortDescending()
        }
        val result = ArrayList<String>()
        val stk = ArrayList<String>()
        stk.add(origin)
        while (stk.isNotEmpty()) {
            while (!adj[stk.last()].isNullOrEmpty()) {
                val x = adj[stk.last()]!!.removeAt(adj[stk.last()]!!.size - 1)
                stk.add(x)
            }
            result.add(stk.removeAt(stk.size - 1))
        }
        result.reverse()
        return result
    }
}
