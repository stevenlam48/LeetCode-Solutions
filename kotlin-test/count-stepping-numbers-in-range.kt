package countsteppingnumbersinrange

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSteppingNumbersInRangeTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(10, solution.countSteppingNumbers("1", "11"))
    }

    @Test
    fun example2() {
        assertEquals(2, solution.countSteppingNumbers("90", "101"))
    }

    @Test
    fun example3() {
        assertEquals(10, solution.countSteppingNumbers("1", "10"))
    }

    @Test
    fun singleNumber() {
        assertEquals(1, solution.countSteppingNumbers("5", "5"))
    }

    @Test
    fun nonSteppingSingle() {
        assertEquals(0, solution.countSteppingNumbers("11", "11"))
    }
}
