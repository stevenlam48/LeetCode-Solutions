package countkreduciblenumberslessthann

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountKReducibleNumbersLessThanNTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.countKReducibleNumbers("1000", 2))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.countKReducibleNumbers("111", 1))
    }

    @Test
    fun testSingleOne() {
        assertEquals(0, solution.countKReducibleNumbers("1", 1))
    }

    @Test
    fun testSmall() {
        assertEquals(1, solution.countKReducibleNumbers("10", 1))
    }

    @Test
    fun testKOne() {
        assertEquals(3, solution.countKReducibleNumbers("1000", 1))
    }
}
