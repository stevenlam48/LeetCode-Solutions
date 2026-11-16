package numberofwaystorearrangestickswithksticksvisible

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToRearrangeSticksWithKSticksVisibleTest {
    @Test
    fun firstExample() {
        assertEquals(3, Solution().rearrangeSticks(3, 2))
    }

    @Test
    fun allVisible() {
        assertEquals(1, Solution().rearrangeSticks(5, 5))
    }

    @Test
    fun onlyTallestVisible() {
        assertEquals(24, Solution().rearrangeSticks(5, 1))
    }

    @Test
    fun secondExample() {
        assertEquals(35, Solution().rearrangeSticks(5, 3))
    }
}
