package countelementswithmaximumfrequency

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountElementsWithMaximumFrequencyTest {
    @Test
    fun example() {
        assertEquals(3, Solution().maxFrequencyElements(intArrayOf(1, 2, 2, 3, 3, 3)))
    }

    @Test
    fun allDistinct() {
        assertEquals(3, Solution().maxFrequencyElements(intArrayOf(1, 2, 3)))
    }

    @Test
    fun tiedFrequencies() {
        assertEquals(4, Solution().maxFrequencyElements(intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maxFrequencyElements(intArrayOf(5)))
    }

    @Test
    fun allSame() {
        assertEquals(4, Solution().maxFrequencyElements(intArrayOf(7, 7, 7, 7)))
    }
}
