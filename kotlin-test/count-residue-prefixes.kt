package countresidueprefixes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountResiduePrefixesTest {
    private val solution = Solution()

    @Test
    fun stopsAtThirdDistinctCharacter() {
        assertEquals(2, solution.residuePrefixes("abc"))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(2, solution.residuePrefixes("ababcc"))
    }

    @Test
    fun oneDistinctCharacter() {
        assertEquals(1, solution.residuePrefixes("dd"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, solution.residuePrefixes(""))
    }
}
