package removezerosindecimalrepresentation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveZerosInDecimalRepresentationTest {
    private val solution = Solution()

    @Test
    fun removesInteriorAndTrailingZeros() {
        assertEquals(123456L, solution.removeZeros(102030405060L))
    }

    @Test
    fun zeroRemainsZero() {
        assertEquals(0L, solution.removeZeros(0L))
    }

    @Test
    fun removesAllZerosAfterLeadingDigit() {
        assertEquals(1L, solution.removeZeros(1000000L))
    }

    @Test
    fun numberWithoutZerosIsUnchanged() {
        assertEquals(987654321L, solution.removeZeros(987654321L))
    }
}
