package findbeautifulindicesinthegivenarrayii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindBeautifulIndicesInTheGivenArrayIiTest {
    @Test
    fun standardExample() {
        assertEquals(
            listOf(16, 33),
            Solution().beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15)
        )
    }

    @Test
    fun identicalPatterns() {
        assertEquals(listOf(0), Solution().beautifulIndices("abcd", "a", "a", 4))
    }

    @Test
    fun overlappingOccurrencesAndZeroDistance() {
        assertEquals(listOf(0, 2), Solution().beautifulIndices("ababa", "aba", "ab", 0))
    }

    @Test
    fun patternLongerThanText() {
        assertEquals(emptyList<Int>(), Solution().beautifulIndices("a", "aa", "a", 0))
    }
}
