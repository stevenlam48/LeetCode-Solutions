package firstelementwithuniquefrequency

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstElementWithUniqueFrequencyTest {
    @Test
    fun repeatedFrequency() {
        assertEquals(3, Solution().firstUniqueFreq(intArrayOf(1, 1, 2, 2, 3)))
    }

    @Test
    fun allFrequenciesUnique() {
        assertEquals(1, Solution().firstUniqueFreq(intArrayOf(1, 2, 2, 3, 3, 3)))
    }

    @Test
    fun noUniqueFrequency() {
        assertEquals(-1, Solution().firstUniqueFreq(intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(7, Solution().firstUniqueFreq(intArrayOf(7)))
    }

    @Test
    fun firstElementWins() {
        assertEquals(5, Solution().firstUniqueFreq(intArrayOf(5, 5, 4)))
    }
}
