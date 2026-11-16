package busroutes

// Time:  O(|V| + |E|)
// Space: O(|V| + |E|)

class Solution {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (source == target) {
            return 0
        }
        val toRoute = HashMap<Int, MutableSet<Int>>()
        for (i in routes.indices) {
            for (stop in routes[i]) {
                toRoute.getOrPut(stop) { HashSet() }.add(i)
            }
        }

        var result = 1
        var queue = listOf(source)
        val lookup = hashSetOf(source)
        while (queue.isNotEmpty()) {
            val nextQueue = ArrayList<Int>()
            for (stop in queue) {
                for (i in toRoute[stop].orEmpty()) {
                    for (nextStop in routes[i]) {
                        if (nextStop in lookup) {
                            continue
                        }
                        if (nextStop == target) {
                            return result
                        }
                        nextQueue.add(nextStop)
                        toRoute[nextStop]?.remove(i)
                        lookup.add(nextStop)
                    }
                }
            }
            queue = nextQueue
            ++result
        }
        return -1
    }
}
