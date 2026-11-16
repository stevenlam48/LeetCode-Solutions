package numberofstepstoreduceanumbertozero

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfStepsToReduceANumberToZeroTest {
    @Test
    fun testExample1() {
        assertEquals(6, Solution().numberOfSteps(14))
    }

    @Test
    fun testExample2() {
        assertEquals(4, Solution().numberOfSteps(8))
    }

    @Test
    fun testExample3() {
        assertEquals(12, Solution().numberOfSteps(123))
    }

    @Test
    fun testZero() {
        assertEquals(0, Solution().numberOfSteps(0))
    }

    @Test
    fun testOne() {
        assertEquals(1, Solution().numberOfSteps(1))
    }
}
