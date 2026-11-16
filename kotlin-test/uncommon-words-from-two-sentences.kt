package uncommonwordsfromtwosentences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UncommonWordsFromTwoSentencesTest {
    @Test
    fun example1() {
        assertEquals(
            setOf("sweet", "sour"),
            Solution().uncommonFromSentences("this apple is sweet", "this apple is sour").toSet()
        )
    }

    @Test
    fun example2() {
        assertEquals(
            listOf("banana"),
            Solution().uncommonFromSentences("apple apple", "banana")
        )
    }

    @Test
    fun allShared() {
        assertEquals(
            emptyList<String>(),
            Solution().uncommonFromSentences("a", "a")
        )
    }

    @Test
    fun allUnique() {
        assertEquals(
            setOf("a", "b"),
            Solution().uncommonFromSentences("a", "b").toSet()
        )
    }
}
