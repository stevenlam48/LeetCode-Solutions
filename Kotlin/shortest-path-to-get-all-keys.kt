package shortestpathtogetallkeys

// Time:  O(k*r*c + |E|log|V|) = O(k*r*c + (k*|V|)*log|V|)
//                             = O(k*r*c + (k*(k*2^k))*log(k*2^k))
//                             = O(k*r*c + (k*(k*2^k))*(logk + k*log2))
//                             = O(k*r*c + (k*(k*2^k))*k)
//                             = O(k*r*c + k^3*2^k)
// Space: O(|V|) = O(k*2^k)

import java.util.PriorityQueue

class Solution {
    private data class Node(val d: Int, val place: Char, val state: Int)

    fun shortestPathAllKeys(grid: List<String>): Int {
        val locations = HashMap<Char, Pair<Int, Int>>()
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] != '.' && grid[r][c] != '#') {
                    locations[grid[r][c]] = r to c
                }
            }
        }
        val dists = HashMap<Char, HashMap<Char, Int>>()
        for (place in locations.keys) {
            dists[place] = bfs(grid, place, locations)
        }

        val minHeap = PriorityQueue(compareBy<Node> { it.d }.thenBy { it.place }.thenBy { it.state })
        minHeap.add(Node(0, '@', 0))
        val best = HashMap<Char, HashMap<Int, Int>>()
        best.getOrPut('@') { HashMap() }[0] = 0
        var count = 0
        for (place in locations.keys) {
            if (place.isLowerCase()) {
                ++count
            }
        }
        val targetState = (1 shl count) - 1
        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            val curD = cur.d
            val place = cur.place
            val state = cur.state
            val previous = best[place]?.get(state)
            if (previous != null && previous < curD) {
                continue
            }
            if (state == targetState) {
                return curD
            }
            for ((dest, d) in dists[place].orEmpty()) {
                var nextState = state
                if (dest.isLowerCase()) {
                    nextState = nextState or (1 shl (dest - 'a'))
                } else if (dest.isUpperCase()) {
                    if (state and (1 shl (dest - 'A')) == 0) {
                        continue
                    }
                }
                val bestDest = best.getOrPut(dest) { HashMap() }
                val current = bestDest[nextState]
                if (current == null || curD + d < current) {
                    bestDest[nextState] = curD + d
                    minHeap.add(Node(curD + d, dest, nextState))
                }
            }
        }
        return -1
    }

    private fun bfs(
        grid: List<String>,
        source: Char,
        locations: HashMap<Char, Pair<Int, Int>>
    ): HashMap<Char, Int> {
        val (sr, sc) = locations[source]!!
        val lookup = Array(grid.size) { BooleanArray(grid[0].length) }
        lookup[sr][sc] = true
        val q = ArrayDeque<IntArray>()
        q.addLast(intArrayOf(sr, sc, 0))
        val dist = HashMap<Char, Int>()
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            val r = cur[0]
            val c = cur[1]
            val d = cur[2]
            if (source != grid[r][c] && grid[r][c] != '.') {
                dist[grid[r][c]] = d
                continue
            }
            for ((dr, dc) in directions) {
                val cr = r + dr
                val cc = c + dc
                if (!(cr in grid.indices && cc in grid[0].indices)) {
                    continue
                }
                if (grid[cr][cc] != '#' && !lookup[cr][cc]) {
                    lookup[cr][cc] = true
                    q.addLast(intArrayOf(cr, cc, d + 1))
                }
            }
        }
        return dist
    }

    companion object {
        private val directions = arrayOf(0 to -1, 0 to 1, -1 to 0, 1 to 0)
    }
}
