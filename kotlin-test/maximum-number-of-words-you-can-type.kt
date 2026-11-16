package maximumnumberofwordsyoucantype

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofwordsyoucantypeTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().canBeTypedWords("hello world", "ad"))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().canBeTypedWords("leet code", "lt"))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().canBeTypedWords("leet code", "e"))
    }

    @Test
    fun noBrokenLetters() {
        assertEquals(2, Solution().canBeTypedWords("hello world", ""))
    }

    @Test
    fun everyWordBroken() {
        assertEquals(0, Solution().canBeTypedWords("a b c", "abc"))
    }
}
