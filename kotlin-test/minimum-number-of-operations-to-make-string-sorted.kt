package minimumnumberofoperationstomakestringsorted

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeStringSortedTest {
    private val solution = Solution()

    @Test
    fun descendingTriple() {
        assertEquals(5, solution.makeStringSorted("cba"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(0, solution.makeStringSorted("a"))
    }

    @Test
    fun unsortedExample() {
        assertEquals(63, solution.makeStringSorted("cdbea"))
    }

    @Test
    fun alreadySorted() {
        assertEquals(0, solution.makeStringSorted("abc"))
    }

    @Test
    fun allSameCharacter() {
        assertEquals(0, solution.makeStringSorted("aaaa"))
    }
}
