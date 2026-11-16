package frequenciesofshortestsupersequences

// Time:  O(n + k^2 * 2^k), k = len(char_to_int) <= 16
// Space: O(k^2)

class Solution {
    fun supersequences(words: List<String>): Array<IntArray> {
        val charToInt = IntArray(26) { -1 }
        val intToChar = IntArray(26)
        val indegree = mutableListOf<Int>()

        fun indexOf(c: Char): Int {
            val x = c - 'a'
            if (charToInt[x] == -1) {
                intToChar[indegree.size] = x
                charToInt[x] = indegree.size
                indegree.add(0)
            }
            return charToInt[x]
        }

        val adj = Array(26) { mutableListOf<Int>() }
        for (word in words) {
            adj[indexOf(word[0])].add(indexOf(word[1]))
            val v = indexOf(word[1])
            indegree[v]++
        }

        var shortest = Int.MAX_VALUE
        val answer = mutableListOf<IntArray>()

        fun topologicalSort(cnt: IntArray) {
            val total = cnt.sum()
            if (total > shortest) {
                return
            }
            val newCnt = cnt.copyOf()
            val newIndegree = indegree.toIntArray()
            val lookup = BooleanArray(cnt.size)
            var queue = mutableListOf<Int>()
            for (u in indegree.indices) {
                if (newIndegree[u] == 0 || newCnt[u] == 2) {
                    newCnt[u]--
                    lookup[u] = true
                    queue.add(u)
                }
            }
            while (queue.isNotEmpty()) {
                val newQueue = mutableListOf<Int>()
                for (u in queue) {
                    for (v in adj[u]) {
                        newIndegree[v]--
                        if (newIndegree[v] != 0) {
                            continue
                        }
                        newCnt[v]--
                        if (lookup[v]) {
                            continue
                        }
                        lookup[v] = true
                        newQueue.add(v)
                    }
                }
                queue = newQueue
            }
            if (newCnt.any { it != 0 }) {
                return
            }
            if (shortest > total) {
                shortest = total
                answer.clear()
            }
            answer.add(cnt)
        }

        for (mask in 0 until (1 shl indegree.size)) {
            val cnt = IntArray(indegree.size) { 1 }
            for (i in indegree.indices) {
                if (mask and (1 shl i) != 0) {
                    cnt[i] = 2
                }
            }
            topologicalSort(cnt)
        }

        val result = Array(answer.size) { IntArray(26) }
        for (i in answer.indices) {
            for (j in answer[i].indices) {
                result[i][intToChar[j]] = answer[i][j]
            }
        }
        return result
    }
}
