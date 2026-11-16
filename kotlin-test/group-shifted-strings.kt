package groupshiftedstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GroupShiftedStringsTest {
    private fun normalize(groups: List<List<String>>): List<List<String>> =
        groups.map { it.sorted() }.sortedBy { it.joinToString(",") }

    @Test
    fun example1() {
        val strings = listOf("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z")
        val expected = listOf(
            listOf("abc", "bcd", "xyz"),
            listOf("az", "ba"),
            listOf("acef"),
            listOf("a", "z")
        )
        assertEquals(normalize(expected), normalize(Solution().groupStrings(strings)))
    }

    @Test
    fun singleString() {
        assertEquals(listOf(listOf("abc")), Solution().groupStrings(listOf("abc")))
    }

    @Test
    fun singleCharactersAllShiftToSame() {
        assertEquals(listOf(listOf("a", "b", "c")), Solution().groupStrings(listOf("a", "b", "c")))
    }

    @Test
    fun sameGroupSorted() {
        assertEquals(listOf(listOf("cd", "de")), Solution().groupStrings(listOf("de", "cd")))
    }

    @Test
    fun hashWrapsAround() {
        assertEquals(Solution().hashStr("ab"), Solution().hashStr("za"))
    }
}
