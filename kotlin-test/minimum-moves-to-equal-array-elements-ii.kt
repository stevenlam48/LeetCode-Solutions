package minimummovestoequalarrayelementsii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToEqualArrayElementsIiTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.minMoves2(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(16, solution.minMoves2(intArrayOf(1, 10, 2, 9)))
    }

    @Test
    fun testAlreadyEqual() {
        assertEquals(0, solution.minMoves2(intArrayOf(4, 4, 4)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.minMoves2(intArrayOf(5)))
    }

    @Test
    fun testTwoElements() {
        assertEquals(3, solution.minMoves2(intArrayOf(1, 4)))
    }

    @Test
    fun testOddLength() {
        assertEquals(14, solution.minMoves2(intArrayOf(1, 0, 0, 8, 6)))
    }
}
