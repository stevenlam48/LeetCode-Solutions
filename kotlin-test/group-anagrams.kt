package groupanagrams

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GroupAnagramsTest {
    private fun normalize(groups: List<List<String>>): List<List<String>> =
        groups.map { it.sorted() }.sortedBy { it.joinToString(",") }

    @Test
    fun example1() {
        val strs = listOf("eat", "tea", "tan", "ate", "nat", "bat")
        val expected = listOf(listOf("ate", "eat", "tea"), listOf("bat"), listOf("nat", "tan"))
        assertEquals(normalize(expected), normalize(Solution().groupAnagrams(strs)))
    }

    @Test
    fun singleEmptyString() {
        assertEquals(listOf(listOf("")), Solution().groupAnagrams(listOf("")))
    }

    @Test
    fun duplicateStrings() {
        val expected = listOf(listOf("", ""))
        assertEquals(normalize(expected), normalize(Solution().groupAnagrams(listOf("", ""))))
    }

    @Test
    fun singleString() {
        assertEquals(listOf(listOf("a")), Solution().groupAnagrams(listOf("a")))
    }

    @Test
    fun noAnagrams() {
        val strs = listOf("abc", "def", "ghi")
        assertEquals(normalize(listOf(listOf("abc"), listOf("def"), listOf("ghi"))), normalize(Solution().groupAnagrams(strs)))
    }
}
