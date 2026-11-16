package validelementsinanarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ValidElementsInAnArrayTest {
    @Test
    fun leetCodeExample() {
        assertArrayEquals(intArrayOf(2, 3), Solution().findValidElements(intArrayOf(2, 1, 3)))
    }

    @Test
    fun strictlyIncreasing() {
        assertArrayEquals(intArrayOf(1, 2, 3, 4), Solution().findValidElements(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun strictlyDecreasing() {
        assertArrayEquals(intArrayOf(4, 3, 2, 1), Solution().findValidElements(intArrayOf(4, 3, 2, 1)))
    }

    @Test
    fun prefixAndSuffixMaxima() {
        assertArrayEquals(intArrayOf(5, 7, 9), Solution().findValidElements(intArrayOf(5, 7, 4, 9)))
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(intArrayOf(), Solution().findValidElements(intArrayOf()))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(7), Solution().findValidElements(intArrayOf(7)))
    }

    @Test
    fun allNegative() {
        assertArrayEquals(intArrayOf(), Solution().findValidElements(intArrayOf(-1, -2, -3)))
    }
}
