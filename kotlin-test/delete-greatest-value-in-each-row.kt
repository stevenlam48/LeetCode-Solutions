package deletegreatestvalueineachrow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteGreatestValueInEachRowTest {
    private val solution = Solution()

    @Test
    fun sumsRemainingMaxima() {
        assertEquals(8, solution.deleteGreatestValue(arrayOf(intArrayOf(1, 2, 4), intArrayOf(3, 3, 1))))
    }

    @Test
    fun singleCell() {
        assertEquals(7, solution.deleteGreatestValue(arrayOf(intArrayOf(7))))
    }

    @Test
    fun duplicateAndZeroValues() {
        assertEquals(4, solution.deleteGreatestValue(arrayOf(intArrayOf(2, 2, 0), intArrayOf(2, 2, 0))))
    }

    @Test
    fun sortingDoesNotLoseValues() {
        assertEquals(12, solution.deleteGreatestValue(arrayOf(intArrayOf(5, 1, 3), intArrayOf(2, 4, 6))))
    }
}
