package countmonobitintegers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountMonobitIntegersTest {
    private val solution = Solution()

    @Test
    fun testZero() {
        assertEquals(1, solution.countMonobit(0))
    }

    @Test
    fun testSmall() {
        assertEquals(2, solution.countMonobit(1))
        assertEquals(2, solution.countMonobit(2))
        assertEquals(3, solution.countMonobit(3))
    }

    @Test
    fun testTen() {
        assertEquals(4, solution.countMonobit(10))
    }

    @Test
    fun testHundred() {
        assertEquals(7, solution.countMonobit(100))
    }
}
