package minimizeinversionsinaprefixtree

// Time:  O(n * l + k * t + n * l * k + n * 2^k + n * l * logk + nlogn) = O(n * l + nlogn), k = 10
// Space: O(k * t + n + k * 2^k) = O(k * t)

import java.util.PriorityQueue

private class Trie {
    private val nodesInternal = ArrayList<IntArray>()

    init {
        newNode()
    }

    fun add(s: String, i: Int) {
        var curr = 0
        for (c in s) {
            val x = c - 'a'
            if (nodesInternal[curr][x] == -1) {
                nodesInternal[curr][x] = newNode()
            }
            curr = nodesInternal[curr][x]
        }
        nodesInternal[curr][10] = i
    }

    fun nodes(): List<IntArray> = nodesInternal

    private fun newNode(): Int {
        nodesInternal.add(IntArray(11) { -1 })
        return nodesInternal.size - 1
    }
}

private data class MergeEntry(val value: Int, val listIndex: Int, val elementIndex: Int)

private fun merge(lists: List<IntArray>): IntArray {
    val minHeap = PriorityQueue(
        compareBy<MergeEntry>({ it.value }, { it.listIndex }, { it.elementIndex })
    )
    var total = 0
    for (i in lists.indices) {
        minHeap.add(MergeEntry(lists[i][0], i, 0))
        total += lists[i].size
    }
    val result = IntArray(total)
    var position = 0
    while (minHeap.isNotEmpty()) {
        val (value, listIndex, elementIndex) = minHeap.remove()
        result[position++] = value
        if (elementIndex + 1 < lists[listIndex].size) {
            minHeap.add(MergeEntry(lists[listIndex][elementIndex + 1], listIndex, elementIndex + 1))
        }
    }
    return result
}

private fun lowerBound(values: IntArray, target: Int): Int {
    var left = 0
    var right = values.size
    while (left < right) {
        val mid = left + (right - left) / 2
        if (values[mid] < target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

class Solution {
    fun minInversions(words: List<String>, target: IntArray): Int {
        val k = 10
        val lookup = IntArray(words.size)
        for (i in words.indices) {
            lookup[target[i]] = i
        }
        val trie = Trie()
        for (i in words.indices) {
            trie.add(words[i], i)
        }
        val nodes = trie.nodes()
        var result = 0
        val costTotal = Array(1 shl k) { IntArray(k) }
        val dp = IntArray(1 shl k)
        val cost = Array(k) { IntArray(k) }
        val merged = Array(nodes.size) { IntArray(0) }
        val lists = ArrayList<IntArray>(k + 1)
        for (u in nodes.size - 1 downTo 0) {
            val node = nodes[u]
            lists.clear()
            for (c in 0 until k) {
                val v = node[c]
                if (v != -1) {
                    lists.add(merged[v])
                }
            }
            if (lists.size >= 2) {
                for (a in lists.indices) {
                    for (b in a + 1 until lists.size) {
                        var count = 0
                        var i = 0
                        for (x in lists[a]) {
                            while (i < lists[b].size && lists[b][i] < x) {
                                ++i
                            }
                            count += i
                        }
                        cost[a][b] = count
                        cost[b][a] = lists[a].size * lists[b].size - count
                    }
                }
                val total = 1 shl lists.size
                dp[0] = 0
                for (c in 0 until lists.size) {
                    costTotal[0][c] = 0
                }
                for (mask in 1 until total) {
                    val low = mask and -mask
                    val a = low.countTrailingZeroBits()
                    for (c in 0 until lists.size) {
                        costTotal[mask][c] = costTotal[mask xor low][c] + cost[a][c]
                    }
                    var min = Int.MAX_VALUE
                    for (c in 0 until lists.size) {
                        if (mask and (1 shl c) != 0) {
                            min = minOf(
                                min,
                                dp[mask xor (1 shl c)] + costTotal[mask xor (1 shl c)][c]
                            )
                        }
                    }
                    dp[mask] = min
                }
                result += dp[total - 1]
            }
            val idx = node[10]
            if (idx != -1) {
                lists.add(intArrayOf(lookup[idx]))
            }
            merged[u] = merge(lists)
            if (idx != -1) {
                result += lowerBound(merged[u], lookup[idx])
            }
        }
        return result
    }
}
