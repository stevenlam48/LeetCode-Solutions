package maximizeactivesectionwithtradeii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximizeActiveSectionWithTradeIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(1),
            solution.maxActiveSectionsAfterTrade("01", arrayOf(intArrayOf(0, 1)))
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(4, 3, 1, 1),
            solution.maxActiveSectionsAfterTrade(
                "0100",
                arrayOf(intArrayOf(0, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(2, 3))
            )
        )
    }

    @Test
    fun testExample3() {
        assertArrayEquals(
            intArrayOf(6, 7, 2),
            solution.maxActiveSectionsAfterTrade(
                "1000100",
                arrayOf(intArrayOf(1, 5), intArrayOf(0, 6), intArrayOf(0, 4))
            )
        )
    }

    @Test
    fun testAlternating() {
        assertArrayEquals(
            intArrayOf(4, 4, 2),
            solution.maxActiveSectionsAfterTrade(
                "01010",
                arrayOf(intArrayOf(0, 3), intArrayOf(1, 4), intArrayOf(1, 3))
            )
        )
    }
}
