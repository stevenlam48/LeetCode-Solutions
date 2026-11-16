package maximumsizedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSizedArrayTest {
    @Test
    fun one() {
        assertEquals(1, Solution().maxSizedArray(1))
    }

    @Test
    fun three() {
        assertEquals(2, Solution().maxSizedArray(3))
    }

    @Test
    fun fortyFive() {
        assertEquals(3, Solution().maxSizedArray(45))
    }

    @Test
    fun twoHundredSixteen() {
        assertEquals(4, Solution().maxSizedArray(216))
    }

    @Test
    fun large() {
        assertEquals(5, Solution().maxSizedArray(840))
    }
}
