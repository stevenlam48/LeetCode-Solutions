package sortingthesentence

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortingTheSentenceTest {
    @Test
    fun exampleOne() {
        assertEquals("This is a sentence", Solution().sortSentence("is2 sentence4 This1 a3"))
    }

    @Test
    fun exampleTwo() {
        assertEquals("Me Myself and I", Solution().sortSentence("Myself2 Me1 I4 and3"))
    }

    @Test
    fun singleWord() {
        assertEquals("a", Solution().sortSentence("a1"))
    }

    @Test
    fun alreadyInOrder() {
        assertEquals("a b c", Solution().sortSentence("a1 b2 c3"))
    }
}
