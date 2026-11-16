package maximumnumberofwordsfoundinsentences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofwordsfoundinsentencesTest {
    @Test
    fun example1() {
        val sentences = arrayOf(
            "alice and bob love leetcode",
            "i think so too",
            "this is great thanks very much"
        )
        assertEquals(6, Solution().mostWordsFound(sentences))
    }

    @Test
    fun example2() {
        val sentences = arrayOf("please wait", "continue to fight", "continue to win")
        assertEquals(3, Solution().mostWordsFound(sentences))
    }

    @Test
    fun singleWord() {
        assertEquals(1, Solution().mostWordsFound(arrayOf("hello")))
    }
}
