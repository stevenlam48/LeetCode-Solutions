package gridillumination

// Time:  O(l + q)
// Space: O(l)

class Solution {
    fun gridIllumination(N: Int, lamps: Array<IntArray>, queries: Array<IntArray>): List<Int> {
        val lookup = HashSet<Long>()
        val row = HashMap<Int, Int>()
        val col = HashMap<Int, Int>()
        val diag = HashMap<Int, Int>()
        val anti = HashMap<Int, Int>()
        for (lamp in lamps) {
            val r = lamp[0]
            val c = lamp[1]
            if (!lookup.add(r.toLong() * N + c)) {
                continue
            }
            row[r] = row.getOrDefault(r, 0) + 1
            col[c] = col.getOrDefault(c, 0) + 1
            diag[r - c] = diag.getOrDefault(r - c, 0) + 1
            anti[r + c] = anti.getOrDefault(r + c, 0) + 1
        }

        val result = ArrayList<Int>()
        for (query in queries) {
            val r = query[0]
            val c = query[1]
            if ((row[r] ?: 0) == 0 && (col[c] ?: 0) == 0 &&
                (diag[r - c] ?: 0) == 0 && (anti[r + c] ?: 0) == 0
            ) {
                result.add(0)
                continue
            }
            result.add(1)
            for (nr in maxOf(r - 1, 0)..minOf(r + 1, N - 1)) {
                for (nc in maxOf(c - 1, 0)..minOf(c + 1, N - 1)) {
                    if (!lookup.remove(nr.toLong() * N + nc)) {
                        continue
                    }
                    row[nr] = row.getOrDefault(nr, 0) - 1
                    col[nc] = col.getOrDefault(nc, 0) - 1
                    diag[nr - nc] = diag.getOrDefault(nr - nc, 0) - 1
                    anti[nr + nc] = anti.getOrDefault(nr + nc, 0) - 1
                }
            }
        }
        return result
    }
}
