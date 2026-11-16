package minimumswapstomakestringsequal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSwapsToMakeStringsEqualTest {
    private val solution = Solution()

    @Test
    fun testSinglePairOfMismatches() {
        assertEquals(1, solution.minimumSwap("xx", "yy"))
        assertEquals(2, solution.minimumSwap("xy", "yx"))
    }

    @Test
    fun testStandardExample() {
        assertEquals(4, solution.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, solution.minimumSwap("xx", "xy"))
        assertEquals(-1, solution.minimumSwap("x", "y"))
    }

    @Test
    fun testEqualStrings() {
        assertEquals(0, solution.minimumSwap("xy", "xy"))
        assertEquals(0, solution.minimumSwap("x", "x"))
    }
}
