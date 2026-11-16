package maximumcompatibilityscoresum

// Time:  O(m^2 * (n + m))
// Space: O(m^2)

class Solution {
    fun maxCompatibilitySum(students: Array<IntArray>, mentors: Array<IntArray>): Int {
        val cost = Array(students.size) { IntArray(mentors.size) }
        for (i in students.indices) {
            for (j in mentors.indices) {
                cost[i][j] = -score(students[i], mentors[j])
            }
        }
        return -hungarian(cost).first
    }

    private fun score(s: IntArray, m: IntArray): Int {
        var result = 0
        for (i in s.indices) {
            result += if (s[i] == m[i]) 1 else 0
        }
        return result
    }

    private fun hungarian(a: Array<IntArray>): Pair<Int, IntArray> {
        if (a.isEmpty()) {
            return 0 to IntArray(0)
        }
        val n = a.size + 1
        val m = a[0].size + 1
        val u = IntArray(n)
        val v = IntArray(m)
        val p = IntArray(m)
        val ans = IntArray(n - 1)
        for (i in 1 until n) {
            p[0] = i
            var j0 = 0
            val dist = IntArray(m) { Int.MAX_VALUE }
            val pre = IntArray(m) { -1 }
            val done = BooleanArray(m + 1)
            do {
                done[j0] = true
                val i0 = p[j0]
                var j1 = -1
                var delta = Int.MAX_VALUE
                for (j in 1 until m) {
                    if (!done[j]) {
                        val cur = a[i0 - 1][j - 1] - u[i0] - v[j]
                        if (cur < dist[j]) {
                            dist[j] = cur
                            pre[j] = j0
                        }
                        if (dist[j] < delta) {
                            delta = dist[j]
                            j1 = j
                        }
                    }
                }
                for (j in 0 until m) {
                    if (done[j]) {
                        u[p[j]] += delta
                        v[j] -= delta
                    } else {
                        dist[j] -= delta
                    }
                }
                j0 = j1
            } while (p[j0] != 0)
            while (j0 != 0) {
                val j1 = pre[j0]
                p[j0] = p[j1]
                j0 = j1
            }
        }
        for (j in 1 until m) {
            if (p[j] != 0) {
                ans[p[j] - 1] = j - 1
            }
        }
        return -v[0] to ans
    }
}
