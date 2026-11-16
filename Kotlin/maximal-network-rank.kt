package maximalnetworkrank

// Time:  O(m + n + k^2), k is the number of values greater or equal to top2
// Space: O(m + n)

class Solution {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val degree = IntArray(n)
        val adj = HashMap<Int, HashSet<Int>>()
        for (road in roads) {
            ++degree[road[0]]
            ++degree[road[1]]
            adj.getOrPut(road[0]) { HashSet() }.add(road[1])
            adj.getOrPut(road[1]) { HashSet() }.add(road[0])
        }
        var sortedIdx = IntArray(n) { it }
        sortedIdx = countingSort(sortedIdx, { x -> degree[x] }, true)
        var m = 2
        while (m < n) {
            if (degree[sortedIdx[m]] != degree[sortedIdx[1]]) break
            ++m
        }
        var result = degree[sortedIdx[0]] + degree[sortedIdx[1]] - 1
        for (i in 0 until m - 1) {
            for (j in i + 1 until m) {
                val connected = if (adj.containsKey(sortedIdx[i]) && adj[sortedIdx[i]]!!.contains(sortedIdx[j])) 1 else 0
                val candidate = degree[sortedIdx[i]] + degree[sortedIdx[j]] - connected
                if (candidate > result) return candidate
            }
        }
        return result
    }

    private fun countingSort(arr: IntArray, key: (Int) -> Int, isReverse: Boolean): IntArray {
        val MAX_N = 100
        val MAX_NUM = MAX_N - 1
        val count = IntArray(MAX_NUM + 1)
        for (x in arr) {
            ++count[key(x)]
        }
        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }
        val result = IntArray(arr.size)
        if (!isReverse) {
            for (i in arr.size - 1 downTo 0) {
                count[key(arr[i])] -= 1
                result[count[key(arr[i])]] = arr[i]
            }
        } else {
            for (x in arr) {
                count[key(x)] -= 1
                result[count[key(x)]] = x
            }
            result.reverse()
        }
        return result
    }
}
