package countnumberofdistinctintegersafterreverseoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfDistinctIntegersAfterReverseOperationsTest {
    @Test
    fun mixedDigitsExample() {
        assertEquals(6, Solution().countDistinctIntegers(intArrayOf(1, 13, 10, 12, 31)))
    }

    @Test
    fun duplicatesProduceNoAdditionalValue() {
        assertEquals(1, Solution().countDistinctIntegers(intArrayOf(2, 2, 2)))
    }

    @Test
    fun zeroReversesToZero() {
        assertEquals(1, Solution().countDistinctIntegers(intArrayOf(0)))
    }

    @Test
    fun trailingZerosDisappearWhenReversed() {
        assertEquals(3, Solution().countDistinctIntegers(intArrayOf(100, 1, 10)))
    }

    @Test
    fun reversedValuesCanMatchOriginals() {
        assertEquals(5, Solution().countDistinctIntegers(intArrayOf(120, 21, 102)))
    }
}
