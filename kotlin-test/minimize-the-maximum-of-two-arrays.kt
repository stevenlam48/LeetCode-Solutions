package minimizethemaximumoftwoarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeTheMaximumOfTwoArraysTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minimizeSet(2, 3, 1, 1))
    }

    @Test
    fun example2() {
        assertEquals(15, Solution().minimizeSet(2, 4, 8, 2))
    }

    @Test
    fun example3() {
        assertEquals(3, Solution().minimizeSet(3, 5, 2, 1))
    }

    @Test
    fun coprimeDivisors() {
        assertEquals(3, Solution().minimizeSet(2, 7, 1, 2))
    }

    @Test
    fun equalDivisors() {
        assertEquals(5, Solution().minimizeSet(3, 3, 2, 2))
    }
}
