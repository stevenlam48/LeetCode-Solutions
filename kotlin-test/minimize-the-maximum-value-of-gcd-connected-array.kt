package minimizethemaximumvalueofgcdconnectedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeTheMaximumValueOfGcdConnectedArrayTest {
    @Test
    fun compositeValue() {
        assertEquals(6L, Solution().minimumMaxValue(3, 1, 4))
    }

    @Test
    fun singleElement() {
        assertEquals(5L, Solution().minimumMaxValue(1, 0, 5))
    }

    @Test
    fun valueOne() {
        assertEquals(-1L, Solution().minimumMaxValue(3, 1, 1))
    }

    @Test
    fun longerArray() {
        assertEquals(12L, Solution().minimumMaxValue(5, 1, 6))
    }

    @Test
    fun lastIndex() {
        assertEquals(9L, Solution().minimumMaxValue(3, 2, 9))
    }

    @Test
    fun impossible() {
        assertEquals(-1L, Solution().minimumMaxValue(4, 1, 3))
    }
}
