package beautifularray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BeautifulArrayTest {
    private val solution = Solution()

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(1), solution.beautifulArray(1))
    }

    @Test
    fun twoElements() {
        assertArrayEquals(intArrayOf(1, 2), solution.beautifulArray(2))
    }

    @Test
    fun filtersPartialPowerOfTwoLayer() {
        assertArrayEquals(intArrayOf(1, 3, 2), solution.beautifulArray(3))
    }

    @Test
    fun exactPowerOfTwoSize() {
        assertArrayEquals(intArrayOf(1, 3, 2, 4), solution.beautifulArray(4))
    }

    @Test
    fun expandsToEightThenFiltersToFive() {
        assertArrayEquals(intArrayOf(1, 5, 3, 2, 4), solution.beautifulArray(5))
    }
}
