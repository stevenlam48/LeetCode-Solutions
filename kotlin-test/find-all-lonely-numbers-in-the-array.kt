package findalllonelynumbersinthearray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAllLonelyNumbersInTheArrayTest {
    @Test
    fun example1() {
        assertEquals(listOf(10, 8), Solution().findLonely(intArrayOf(10, 6, 5, 8)))
    }

    @Test
    fun example2() {
        assertEquals(listOf(1, 5), Solution().findLonely(intArrayOf(1, 3, 5, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(listOf(7), Solution().findLonely(intArrayOf(7)))
    }

    @Test
    fun duplicatePair() {
        assertEquals(emptyList<Int>(), Solution().findLonely(intArrayOf(1, 1)))
    }

    @Test
    fun consecutiveValues() {
        assertEquals(emptyList<Int>(), Solution().findLonely(intArrayOf(1, 2, 3)))
    }

    @Test
    fun negativeValues() {
        assertEquals(emptyList<Int>(), Solution().findLonely(intArrayOf(-1, -2)))
    }
}
