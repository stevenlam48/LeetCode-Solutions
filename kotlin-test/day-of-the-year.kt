package dayoftheyear

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayOfTheYearTest {
    @Test
    fun example1() {
        assertEquals(9, Solution().dayOfYear("2019-01-09"))
    }

    @Test
    fun example2() {
        assertEquals(41, Solution().dayOfYear("2019-02-10"))
    }

    @Test
    fun example3() {
        assertEquals(60, Solution().dayOfYear("2003-03-01"))
    }

    @Test
    fun example4() {
        assertEquals(61, Solution().dayOfYear("2004-03-01"))
    }

    @Test
    fun fullYear() {
        assertEquals(365, Solution().dayOfYear("2019-12-31"))
        assertEquals(366, Solution().dayOfYear("2020-12-31"))
    }

    @Test
    fun centuryNonLeap() {
        assertEquals(60, Solution().dayOfYear("1900-03-01"))
        assertEquals(61, Solution().dayOfYear("2000-03-01"))
    }
}
