package minimummovestoequalarrayelements

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToEqualArrayElementsTest {

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
    fun testTwoElements() {
        assertEquals(1, solution.minMoves(intArrayOf(1, 2)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.minMoves(intArrayOf(7)))
    }

    @Test
    fun testDuplicates() {
        assertEquals(5, solution.minMoves(intArrayOf(5, 5, 10)))
    }

    @Test
    fun testLargeGap() {
        assertEquals(9, solution.minMoves(intArrayOf(1, 10)))
    }
}
