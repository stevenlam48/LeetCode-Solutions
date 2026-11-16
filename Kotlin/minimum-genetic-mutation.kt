package minimumgeneticmutation

// Time:  O(n * b), n is the length of gene string, b is size of bank
// Space: O(b)

class Solution {
    fun minMutation(start: String, end: String, bank: List<String>): Int {
        val lookup = HashMap<String, Boolean>()
        for (b in bank) {
            lookup[b] = false
        }

        val q = ArrayDeque<Pair<String, Int>>()
        q.addLast(Pair(start, 0))
        while (q.isNotEmpty()) {
            val (cur, level) = q.removeFirst()

            if (cur == end) {
                return level
            }

            for (i in cur.indices) {
                val curCopy = cur.toCharArray()
                for (c in charArrayOf('A', 'T', 'C', 'G')) {
                    if (curCopy[i] == c) {
                        continue
                    }
                    curCopy[i] = c
                    val next = String(curCopy)
                    if (lookup.containsKey(next) && lookup[next] == false) {
                        q.addLast(Pair(next, level + 1))
                        lookup[next] = true
                    }
                }
            }
        }

        return -1
    }
}
