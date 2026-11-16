package replaceallstoavoidconsecutiverepeatingcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReplaceAllSToAvoidConsecutiveRepeatingCharactersTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals("azs", solution.modifyString("?zs"))
    }

    @Test
    fun secondExample() {
        assertEquals("ubvaw", solution.modifyString("ubv?w"))
    }

    @Test
    fun consecutiveQuestionMarksUseDifferentLetters() {
        assertEquals("ab", solution.modifyString("??"))
    }

    @Test
    fun replacementAvoidsBothNeighbors() {
        assertEquals("aba", solution.modifyString("a?a"))
    }

    @Test
    fun singleQuestionMarkBecomesA() {
        assertEquals("a", solution.modifyString("?"))
    }
}
