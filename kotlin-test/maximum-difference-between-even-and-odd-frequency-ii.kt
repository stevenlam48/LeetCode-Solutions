package maximumdifferencebetweenevenandoddfrequencyii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDifferenceBetweenEvenAndOddFrequencyIITest {
    @Test
    fun firstExample() {
        assertEquals(-1, Solution().maxDifference("12233", 4))
    }

    @Test
    fun secondExample() {
        assertEquals(3, Solution().maxDifference("11222222", 3))
    }

    @Test
    fun exactLengthWindow() {
        assertEquals(1, Solution().maxDifference("11122", 5))
    }
}
