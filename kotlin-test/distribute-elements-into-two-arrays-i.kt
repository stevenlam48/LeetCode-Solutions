package distributeelementsintotwoarraysi

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DistributeElementsIntoTwoArraysITest {
    private val solution = Solution()

    @Test
    fun appendToFirstArray() {
        assertArrayEquals(intArrayOf(2, 3, 1), solution.resultArray(intArrayOf(2, 1, 3)))
    }

    @Test
    fun compareLastElements() {
        assertArrayEquals(intArrayOf(5, 3, 4, 8), solution.resultArray(intArrayOf(5, 4, 3, 8)))
    }

    @Test
    fun minimumSize() {
        assertArrayEquals(intArrayOf(1, 1), solution.resultArray(intArrayOf(1, 1)))
    }
}
