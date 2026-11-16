package randomflipmatrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomFlipMatrixTest {
    @Test
    fun testAllCellsCovered() {
        val solution = Solution(2, 3)
        val seen = HashSet<Pair<Int, Int>>()
        repeat(6) {
            val cell = solution.flip()
            assertTrue(cell[0] in 0 until 2)
            assertTrue(cell[1] in 0 until 3)
            assertTrue(seen.add(Pair(cell[0], cell[1])))
        }
        assertEquals(6, seen.size)
    }

    @Test
    fun testReset() {
        val solution = Solution(1, 1)
        assertArrayEquals(intArrayOf(0, 0), solution.flip())
        solution.reset()
        assertArrayEquals(intArrayOf(0, 0), solution.flip())
    }

    @Test
    fun testResetAllowsAllCellsAgain() {
        val solution = Solution(2, 2)
        repeat(4) { solution.flip() }
        solution.reset()
        val seen = HashSet<Pair<Int, Int>>()
        repeat(4) {
            val cell = solution.flip()
            assertTrue(seen.add(Pair(cell[0], cell[1])))
        }
        assertEquals(4, seen.size)
    }
}
