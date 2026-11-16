package maximizeamountaftertwodaysofconversions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeAmountAfterTwoDaysOfConversionsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            4.0,
            solution.maxAmount(
                "USD",
                listOf(listOf("USD", "EUR")),
                doubleArrayOf(2.0),
                listOf(listOf("EUR", "USD")),
                doubleArrayOf(2.0)
            ),
            1e-9
        )
    }

    @Test
    fun testNoConversions() {
        assertEquals(
            1.0,
            solution.maxAmount("USD", emptyList(), doubleArrayOf(), emptyList(), doubleArrayOf()),
            1e-9
        )
    }

    @Test
    fun testCannotReturn() {
        assertEquals(
            1.0,
            solution.maxAmount(
                "A",
                listOf(listOf("A", "B")),
                doubleArrayOf(3.0),
                listOf(listOf("B", "C")),
                doubleArrayOf(2.0)
            ),
            1e-9
        )
    }

    @Test
    fun testRoundTrip() {
        assertEquals(
            6.0,
            solution.maxAmount(
                "A",
                listOf(listOf("A", "B")),
                doubleArrayOf(2.0),
                listOf(listOf("B", "A")),
                doubleArrayOf(3.0)
            ),
            1e-9
        )
    }
}
