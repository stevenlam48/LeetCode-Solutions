package minimummovestoconvertstring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToConvertStringTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.minimumMoves("XXX"))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.minimumMoves("XXOX"))
    }

    @Test
    fun testExample3() {
        assertEquals(0, solution.minimumMoves("OOOO"))
    }

    @Test
    fun testSingleX() {
        assertEquals(1, solution.minimumMoves("X"))
    }

    @Test
    fun testSingleO() {
        assertEquals(0, solution.minimumMoves("O"))
    }

    @Test
    fun testSeparatedX() {
        assertEquals(2, solution.minimumMoves("XOXOX"))
    }
}
