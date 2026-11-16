package stampingthesequence

// Time:  O((n - m) * m)
// Space: O((n - m) * m)

class Solution {
    fun movesToStamp(stamp: String, target: String): IntArray {
        val M = stamp.length
        val N = target.length

        val q = ArrayDeque<Int>()
        val lookup = BooleanArray(N)
        val result = ArrayList<Int>()
        val A = ArrayList<Pair<MutableSet<Int>, MutableSet<Int>>>()
        for (i in 0 until N - M + 1) {
            val made = HashSet<Int>()
            val todo = HashSet<Int>()
            for (j in 0 until M) {
                if (stamp[j] == target[i + j]) {
                    made.add(i + j)
                } else {
                    todo.add(i + j)
                }
            }
            A.add(Pair(made, todo))
            if (todo.isNotEmpty()) {
                continue
            }
            result.add(i)
            for (m in made) {
                if (lookup[m]) {
                    continue
                }
                q.addLast(m)
                lookup[m] = true
            }
        }

        while (q.isNotEmpty()) {
            val i = q.removeFirst()
            for (j in maxOf(0, i - M + 1) until minOf(N - M, i) + 1) {
                val made = A[j].first
                val todo = A[j].second
                if (!todo.contains(i)) {
                    continue
                }
                todo.remove(i)
                if (todo.isNotEmpty()) {
                    continue
                }
                result.add(j)
                for (m in made) {
                    if (lookup[m]) {
                        continue
                    }
                    q.addLast(m)
                    lookup[m] = true
                }
            }
        }
        if (lookup.all { it }) {
            result.reverse()
            return result.toIntArray()
        }
        return IntArray(0)
    }
}
