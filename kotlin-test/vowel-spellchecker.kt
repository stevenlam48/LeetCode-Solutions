package vowelspellchecker

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class VowelSpellcheckerTest {
    private val solution = Solution()

    @Test
    fun appliesAllMatchingRules() {
        val queries = arrayOf("kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto")
        val result = solution.spellchecker(listOf("KiTe", "kite", "hare", "Hare"), queries)
        assertSame(queries, result)
        assertArrayEquals(
            arrayOf("kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"),
            result
        )
    }

    @Test
    fun preservesExactMatchAndFirstWordlistMatch() {
        val result = solution.spellchecker(listOf("kite", "KiTe"), arrayOf("KiTe", "KITE"))
        assertArrayEquals(arrayOf("KiTe", "kite"), result)
    }

    @Test
    fun returnsEmptyStringsForUnknownQueries() {
        val result = solution.spellchecker(listOf("yellow"), arrayOf("yellw", "blue", "Ylow"))
        assertArrayEquals(arrayOf("", "", ""), result)
    }
}
