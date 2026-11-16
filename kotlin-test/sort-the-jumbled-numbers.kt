package sortthejumblednumbers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortTheJumbledNumbersTest {
    @Test
    fun standardMappedExample() {
        val mapping = intArrayOf(8, 9, 4, 0, 2, 1, 3, 5, 7, 6)
        assertArrayEquals(
            intArrayOf(338, 38, 991),
            Solution().sortJumbled(mapping, intArrayOf(991, 338, 38))
        )
    }

    @Test
    fun identityMappingPreservesValuesOnlyByValue() {
        val mapping = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertArrayEquals(
            intArrayOf(123, 456, 789),
            Solution().sortJumbled(mapping, intArrayOf(789, 456, 123))
        )
    }

    @Test
    fun equalMappedValuesPreserveOriginalOrder() {
        val mapping = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        assertArrayEquals(
            intArrayOf(12, 1, 0, 99),
            Solution().sortJumbled(mapping, intArrayOf(12, 1, 0, 99))
        )
    }

    @Test
    fun zeroUsesItsMappedDigit() {
        val mapping = intArrayOf(5, 1, 2, 3, 4, 0, 6, 7, 8, 9)
        assertArrayEquals(
            intArrayOf(5, 0),
            Solution().sortJumbled(mapping, intArrayOf(0, 5))
        )
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(
            intArrayOf(),
            Solution().sortJumbled(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), intArrayOf())
        )
    }
}
