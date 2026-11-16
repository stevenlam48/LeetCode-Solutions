package maximizeactivesectionwithtradei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeActiveSectionWithTradeITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.maxActiveSectionsAfterTrade("01"))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.maxActiveSectionsAfterTrade("0100"))
    }

    @Test
    fun testExample3() {
        assertEquals(7, solution.maxActiveSectionsAfterTrade("1000100"))
    }

    @Test
    fun testAlternating() {
        assertEquals(4, solution.maxActiveSectionsAfterTrade("01010"))
    }

    @Test
    fun testAllZeros() {
        assertEquals(0, solution.maxActiveSectionsAfterTrade("0"))
    }

    @Test
    fun testAllOnes() {
        assertEquals(3, solution.maxActiveSectionsAfterTrade("111"))
    }
}
