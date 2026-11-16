package minimummovestoequalarrayelementsiii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToEqualArrayElementsIiiTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.minMoves(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testAlreadyEqual() {
        assertEquals(0, solution.minMoves(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.minMoves(intArrayOf(5)))
    }

    @Test
    fun testTwoElements() {
        assertEquals(99, solution.minMoves(intArrayOf(1, 100)))
    }

    @Test
    fun testDuplicates() {
        assertEquals(10, solution.minMoves(intArrayOf(5, 5, 10)))
    }

    @Test
    fun testZeros() {
        assertEquals(4, solution.minMoves(intArrayOf(0, 0, 2, 2)))
    }
}
