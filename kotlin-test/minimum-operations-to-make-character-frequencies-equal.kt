package minimumoperationstomakecharacterfrequenciesequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeCharacterFrequenciesEqualTest {
    @Test
    fun alreadyEqualFrequencies() {
        assertEquals(0, Solution().makeStringGood("abc"))
        assertEquals(0, Solution().makeStringGood("aaa"))
        assertEquals(0, Solution().makeStringGood("a"))
    }

    @Test
    fun deleteOneCharacter() {
        assertEquals(1, Solution().makeStringGood("aab"))
    }

    @Test
    fun insertOneCharacter() {
        assertEquals(1, Solution().makeStringGood("aaabbbcc"))
    }

    @Test
    fun twoDistinctFrequencies() {
        assertEquals(1, Solution().makeStringGood("aabbc"))
    }
}
