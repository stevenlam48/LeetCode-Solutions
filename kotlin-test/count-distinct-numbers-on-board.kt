package countdistinctnumbersonboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDistinctNumbersOnBoardTest {
    @Test
    fun one() {
        assertEquals(1, Solution().distinctIntegers(1))
    }

    @Test
    fun two() {
        assertEquals(1, Solution().distinctIntegers(2))
    }

    @Test
    fun three() {
        assertEquals(2, Solution().distinctIntegers(3))
    }

    @Test
    fun five() {
        assertEquals(4, Solution().distinctIntegers(5))
    }

    @Test
    fun large() {
        assertEquals(999_999_999, Solution().distinctIntegers(1_000_000_000))
    }
}
