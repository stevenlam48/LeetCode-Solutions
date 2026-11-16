package maximizethetotalheightofuniquetowers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheTotalHeightOfUniqueTowersTest {
    @Test
    fun distinctHeights() {
        assertEquals(14L, Solution().maximumTotalSum(intArrayOf(5, 4, 3, 2)))
    }

    @Test
    fun impossible() {
        assertEquals(-1L, Solution().maximumTotalSum(intArrayOf(2, 2, 1)))
    }

    @Test
    fun duplicatesReduced() {
        assertEquals(10L, Solution().maximumTotalSum(intArrayOf(2, 3, 4, 3)))
    }

    @Test
    fun singleTower() {
        assertEquals(1L, Solution().maximumTotalSum(intArrayOf(1)))
    }
}
