package minimumsecondstoequalizeacirculararray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSecondsToEqualizeACircularArrayTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minimumSeconds(intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun allDistinct() {
        assertEquals(2, Solution().minimumSeconds(intArrayOf(2, 1, 3, 4, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().minimumSeconds(intArrayOf(5)))
    }

    @Test
    fun allEqual() {
        assertEquals(0, Solution().minimumSeconds(intArrayOf(5, 5, 5)))
    }
}
