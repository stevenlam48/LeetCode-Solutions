package randompointinnonoverlappingrectangles

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomPointInNonOverlappingRectanglesTest {
    @Test
    fun testAllPointsReachable() {
        val rects = arrayOf(
            intArrayOf(-2, -2, -1, -1),
            intArrayOf(1, 0, 3, 0)
        )
        val solution = Solution(rects)
        val valid = setOf(
            Pair(-2, -2), Pair(-2, -1), Pair(-1, -2), Pair(-1, -1),
            Pair(1, 0), Pair(2, 0), Pair(3, 0)
        )
        val seen = HashSet<Pair<Int, Int>>()
        repeat(5000) {
            val point = solution.pick()
            val p = Pair(point[0], point[1])
            assertTrue(p in valid)
            seen.add(p)
        }
        assertEquals(valid, seen)
    }

    @Test
    fun testSingleCell() {
        val solution = Solution(arrayOf(intArrayOf(5, 5, 5, 5)))
        repeat(20) {
            assertArrayEquals(intArrayOf(5, 5), solution.pick())
        }
    }

    @Test
    fun testSingleRect() {
        val solution = Solution(arrayOf(intArrayOf(0, 0, 1, 1)))
        val seen = HashSet<Pair<Int, Int>>()
        repeat(2000) {
            val point = solution.pick()
            assertTrue(point[0] in 0..1)
            assertTrue(point[1] in 0..1)
            seen.add(Pair(point[0], point[1]))
        }
        assertEquals(4, seen.size)
    }
}
