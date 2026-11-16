package smallestnumberwithgivendigitproduct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestNumberWithGivenDigitProductTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals("49", solution.smallestNumber(36L))
        assertEquals("455", solution.smallestNumber(100L))
    }

    @Test
    fun singleDigitAndOne() {
        assertEquals("1", solution.smallestNumber(1L))
        assertEquals("7", solution.smallestNumber(7L))
        assertEquals("8", solution.smallestNumber(8L))
    }

    @Test
    fun impossibleProducts() {
        assertEquals("-1", solution.smallestNumber(13L))
        assertEquals("-1", solution.smallestNumber(22L))
    }

    @Test
    fun repeatedFactors() {
        assertEquals("2888", solution.smallestNumber(1024L))
        assertEquals("399", solution.smallestNumber(243L))
    }
}
