package countfancynumbersinarange

// Time:  O(dlogd + g + d^2 + g * d) = O(g * d + d^2), d = logr, g = len(good)
// Space: O(g + d)

// bfs, dp, principle of inclusion and exclusion
class Solution {
    fun countFancy(l: Long, r: Long): Long {
        fun count(x: Long): Long {
            fun total(n0: Long): Int {
                var n = n0
                var result = 0
                while (n != 0L) {
                    result += (n % 10).toInt()
                    n /= 10
                }
                return result
            }

            fun length(n0: Long): Int {
                var n = n0
                var result = 0
                while (n != 0L) {
                    ++result
                    n /= 10
                }
                return result
            }

            fun check(n0: Int): Boolean {
                var n = n0
                var asc = true
                var desc = true
                while (n >= 10) {
                    if (!((n / 10) % 10 < n % 10)) {
                        asc = false
                    }
                    if (!((n / 10) % 10 > n % 10)) {
                        desc = false
                    }
                    n /= 10
                }
                return asc || desc
            }

            fun bfs(x: Long): MutableList<Long> {
                val result = mutableListOf<Long>()
                val limit = minOf(9L, x)
                var i = 1L
                while (i <= limit) {
                    result.add(i)
                    ++i
                }
                for (diff in intArrayOf(1, -1)) {
                    var q = mutableListOf<Long>()
                    i = 1L
                    while (i <= limit) {
                        q.add(i)
                        ++i
                    }
                    while (q.isNotEmpty()) {
                        val newQ = mutableListOf<Long>()
                        for (u in q) {
                            val curr = (u % 10).toInt()
                            var d = curr + diff
                            while (d in 0..9) {
                                val v = u * 10 + d
                                if (v <= x) {
                                    newQ.add(v)
                                    result.add(v)
                                }
                                d += diff
                            }
                        }
                        q = newQ
                    }
                }
                return result
            }

            val lookup = BooleanArray(length(x) * 9 + 1)

            fun dp(x0: Long): Long {
                val l = length(x0)
                val mx = l * 9
                var dp = Array(2) { LongArray(mx + 1) }
                dp[1][0] = 1
                var base = 1L
                for (i in 1 until l) {
                    base *= 10
                }
                for (i in 0 until l) {
                    val newDp = Array(2) { LongArray(mx + 1) }
                    val v = (x0 / base) % 10
                    base /= 10
                    for (t in 0..1) {
                        for (s in 0..mx) {
                            if (dp[t][s] == 0L) {
                                continue
                            }
                            val bound = if (t == 1) v else 9L
                            var d = 0L
                            while (d <= bound) {
                                newDp[if (t == 1 && d == v) 1 else 0][s + d.toInt()] += dp[t][s]
                                ++d
                            }
                        }
                    }
                    dp = newDp
                }

                var result = 0L
                for (i in 0..mx) {
                    if (lookup[i]) {
                        result += dp[0][i] + dp[1][i]
                    }
                }
                return result
            }

            for (i in lookup.indices) {
                lookup[i] = check(i)
            }
            val good = bfs(x)
            var cnt = 0L
            for (g in good) {
                if (lookup[total(g)]) {
                    ++cnt
                }
            }
            return good.size.toLong() + dp(x) - cnt
        }

        return count(r) - count(l - 1)
    }
}
