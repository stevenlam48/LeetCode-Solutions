package findscoreofanarrayaftermarkingallelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindScoreOfAnArrayAfterMarkingAllElementsTest {
    @Test
    fun testExample1() {
        assertEquals(7L, Solution().findScore(intArrayOf(2, 1, 3, 4, 5, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(5L, Solution().findScore(intArrayOf(2, 3, 5, 1, 3, 2)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(42L, Solution().findScore(intArrayOf(42)))
    }

    @Test
    fun testDuplicates() {
        assertEquals(2L, Solution().findScore(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testLargeValues() {
        assertEquals(
            1_000_000_000L,
            Solution().findScore(intArrayOf(1_000_000_000, 1_000_000_000))
        )
    }
}
