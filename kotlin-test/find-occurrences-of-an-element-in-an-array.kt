package findoccurrencesofanelementinanarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindOccurrencesOfAnElementInAnArrayTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertArrayEquals(
            intArrayOf(0, -1, 2, -1),
            solution.occurrencesOfElement(intArrayOf(1, 3, 1, 7), intArrayOf(1, 3, 2, 4), 1)
        )
    }

    @Test
    fun exampleNoOccurrences() {
        assertArrayEquals(intArrayOf(-1), solution.occurrencesOfElement(intArrayOf(1, 2, 3), intArrayOf(10), 5))
    }

    @Test
    fun everyElementMatches() {
        assertArrayEquals(
            intArrayOf(0, 1, 2),
            solution.occurrencesOfElement(intArrayOf(-2, -2, -2), intArrayOf(1, 2, 3), -2)
        )
    }
}
