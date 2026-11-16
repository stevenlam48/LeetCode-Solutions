package maximizeamountaftertwodaysofconversions

// Time:  O(n^2)
// Space: O(n)

// Bellman-Ford Algorithm
class Solution {
    fun maxAmount(
        initialCurrency: String,
        pairs1: List<List<String>>,
        rates1: DoubleArray,
        pairs2: List<List<String>>,
        rates2: DoubleArray
    ): Double {
        val dist = HashMap<String, Double>()
        dist[initialCurrency] = 1.0
        bellmanFord(dist, pairs1, rates1)
        bellmanFord(dist, pairs2, rates2)
        return dist[initialCurrency]!!
    }

    private fun bellmanFord(dist: HashMap<String, Double>, pairs: List<List<String>>, rates: DoubleArray) {
        for (iteration in pairs.indices) {
            for (i in pairs.indices) {
                val a = pairs[i][0]
                val b = pairs[i][1]
                dist[b] = maxOf(dist[b] ?: 0.0, (dist[a] ?: 0.0) * rates[i])
                dist[a] = maxOf(dist[a] ?: 0.0, (dist[b] ?: 0.0) * (1.0 / rates[i]))
            }
        }
    }
}
