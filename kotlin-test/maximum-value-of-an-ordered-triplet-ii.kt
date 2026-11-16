package maximumvalueofanorderedtripletii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValueOfAnOrderedTripletIITest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(77L, solution.maximumTripletValue(intArrayOf(12, 6, 1, 2, 7)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(133L, solution.maximumTripletValue(intArrayOf(1, 10, 3, 4, 19)))
    }

    @Test
    fun increasingTripletHasNoPositiveValue() {
        assertEquals(0L, solution.maximumTripletValue(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allNegativeValues() {
        assertEquals(0L, solution.maximumTripletValue(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun largeValuesUseLong() {
        assertEquals(999999000000L, solution.maximumTripletValue(intArrayOf(1000000, 1, 1000000)))
    }
}
