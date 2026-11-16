package numberofsubsequenceswithoddsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubsequencesWithOddSumTest {
    private val solution = Solution()

    @Test
    fun mixedParities() {
        assertEquals(4, solution.subsequenceCount(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allEven() {
        assertEquals(0, solution.subsequenceCount(intArrayOf(2, 4, 6)))
    }

    @Test
    fun allOdd() {
        assertEquals(4, solution.subsequenceCount(intArrayOf(1, 1, 1)))
    }

    @Test
    fun emptyAndSingleElement() {
        assertEquals(0, solution.subsequenceCount(intArrayOf()))
        assertEquals(1, solution.subsequenceCount(intArrayOf(1)))
        assertEquals(0, solution.subsequenceCount(intArrayOf(2)))
    }
}
