package themostsimilarpathinagraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TheMostSimilarPathInAGraphTest {

    private fun assertValidPath(
        n: Int,
        roads: Array<IntArray>,
        names: Array<String>,
        target: Array<String>,
        expectedCost: Int,
        path: IntArray
    ) {
        assertEquals(target.size, path.size)
        val adj = Array(n) { HashSet<Int>() }
        for (r in roads) {
            adj[r[0]].add(r[1])
            adj[r[1]].add(r[0])
        }
        for (v in path) {
            assertTrue(v in 0 until n, "node out of range")
        }
        for (i in 1 until path.size) {
            assertTrue(adj[path[i - 1]].contains(path[i]), "consecutive nodes are not adjacent")
        }
        var cost = 0
        for (i in path.indices) {
            if (names[path[i]] != target[i]) {
                ++cost
            }
        }
        assertEquals(expectedCost, cost)
    }

    @Test
    fun testExample1() {
        val roads = arrayOf(
            intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 2),
            intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 4)
        )
        val names = arrayOf("ATL", "PEK", "LAX", "DXB", "HND")
        val target = arrayOf("ATL", "DXB", "HND", "LAX")
        assertValidPath(5, roads, names, target, 1, Solution().mostSimilar(5, roads, names, target))
    }

    @Test
    fun testExample2() {
        val roads = arrayOf(
            intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 0),
            intArrayOf(2, 1), intArrayOf(3, 1), intArrayOf(3, 2)
        )
        val names = arrayOf("ATL", "PEK", "LAX", "DXB")
        val target = arrayOf("ABC", "DEF", "GHI", "JKL", "MNO", "PQR")
        assertValidPath(4, roads, names, target, 6, Solution().mostSimilar(4, roads, names, target))
    }

    @Test
    fun testExample3() {
        val roads = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3),
            intArrayOf(3, 4), intArrayOf(4, 5)
        )
        val names = arrayOf("ATL", "PEK", "LAX", "ATL", "DXB", "HND")
        val target = arrayOf("ATL", "DXB", "HND", "DXB", "ATL", "LAX", "ATL")
        assertValidPath(6, roads, names, target, 0, Solution().mostSimilar(6, roads, names, target))
    }

    @Test
    fun testSingleNode() {
        val roads = arrayOf<IntArray>()
        val names = arrayOf("ATL")
        val target = arrayOf("ATL")
        assertValidPath(1, roads, names, target, 0, Solution().mostSimilar(1, roads, names, target))
    }

    @Test
    fun testTwoNodes() {
        val roads = arrayOf(intArrayOf(0, 1))
        val names = arrayOf("A", "B")
        val target = arrayOf("B", "A")
        assertValidPath(2, roads, names, target, 0, Solution().mostSimilar(2, roads, names, target))
    }
}
