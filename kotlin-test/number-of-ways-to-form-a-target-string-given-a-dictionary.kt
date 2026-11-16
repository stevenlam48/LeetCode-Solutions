package numberofwaystoformatargetstringgivenadictionary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToFormATargetStringGivenADictionaryTest {
    @Test
    fun firstExample() {
        assertEquals(6, Solution().numWays(listOf("acca", "bbbb", "caca"), "aba"))
    }

    @Test
    fun secondExample() {
        assertEquals(4, Solution().numWays(listOf("abba", "baab"), "bab"))
    }

    @Test
    fun impossibleTarget() {
        assertEquals(0, Solution().numWays(listOf("a"), "aa"))
    }
}
