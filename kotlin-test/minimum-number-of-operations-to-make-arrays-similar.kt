package minimumnumberofoperationstomakearrayssimilar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeArraysSimilarTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(2L, solution.makeSimilar(intArrayOf(8, 12, 6), intArrayOf(2, 14, 10)))
    }

    @Test
    fun oddNumbers() {
        assertEquals(2L, solution.makeSimilar(intArrayOf(1, 3), intArrayOf(5, 7)))
    }

    @Test
    fun evenNumbers() {
        assertEquals(1L, solution.makeSimilar(intArrayOf(2, 2), intArrayOf(4, 0)))
    }

    @Test
    fun mixedParity() {
        assertEquals(0L, solution.makeSimilar(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun twoOddElements() {
        assertEquals(1L, solution.makeSimilar(intArrayOf(1, 5), intArrayOf(3, 3)))
    }
}
