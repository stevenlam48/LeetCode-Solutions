package numberofvalidclocktimes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfValidClockTimesTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().countTime("?5:00"))
    }

    @Test
    fun example2() {
        assertEquals(100, Solution().countTime("0?:0?"))
    }

    @Test
    fun allUnknown() {
        assertEquals(1440, Solution().countTime("??:??"))
    }

    @Test
    fun hourStartsWithTwo() {
        assertEquals(240, Solution().countTime("2?:??"))
    }

    @Test
    fun hourStartsWithOne() {
        assertEquals(600, Solution().countTime("1?:??"))
    }
}
