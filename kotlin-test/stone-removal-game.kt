package stoneremovalgame

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StoneRemovalGameTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.canAliceWin(12))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.canAliceWin(1))
    }

    @Test
    fun testFifteen() {
        assertTrue(solution.canAliceWin(15))
    }

    @Test
    fun testExactFullSequence() {
        assertFalse(solution.canAliceWin(55))
    }

    @Test
    fun testOneShortOfFullSequence() {
        assertTrue(solution.canAliceWin(54))
    }
}
