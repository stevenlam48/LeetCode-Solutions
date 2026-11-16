package brokencalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BrokenCalculatorTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().brokenCalc(2, 3))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().brokenCalc(5, 8))
    }

    @Test
    fun example3() {
        assertEquals(3, Solution().brokenCalc(3, 10))
    }

    @Test
    fun alreadyEqual() {
        assertEquals(0, Solution().brokenCalc(1, 1))
    }

    @Test
    fun onlyDecrement() {
        assertEquals(1023, Solution().brokenCalc(1024, 1))
    }
}
