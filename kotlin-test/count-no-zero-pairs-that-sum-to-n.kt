package countnozeropairsthatsumton

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNoZeroPairsThatSumToNTest {
    private val solution = Solution()

    @Test
    fun testOne() {
        assertEquals(0L, solution.countNoZeroPairs(1L))
    }

    @Test
    fun testTwo() {
        assertEquals(1L, solution.countNoZeroPairs(2L))
    }

    @Test
    fun testTen() {
        assertEquals(9L, solution.countNoZeroPairs(10L))
    }

    @Test
    fun testEleven() {
        assertEquals(8L, solution.countNoZeroPairs(11L))
    }

    @Test
    fun testHundred() {
        assertEquals(90L, solution.countNoZeroPairs(100L))
    }

    @Test
    fun testLarge() {
        assertEquals(82L, solution.countNoZeroPairs(123L))
    }
}
