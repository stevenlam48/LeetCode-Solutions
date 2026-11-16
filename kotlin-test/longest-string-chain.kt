package longeststringchain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestStringChainTest {
    @Test
    fun standardExample() {
        assertEquals(4, Solution().longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca")))
    }

    @Test
    fun anotherStandardExample() {
        assertEquals(5, Solution().longestStrChain(arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
    }

    @Test
    fun singleWord() {
        assertEquals(1, Solution().longestStrChain(arrayOf("a")))
    }

    @Test
    fun repeatedCharacterChain() {
        assertEquals(3, Solution().longestStrChain(arrayOf("a", "aa", "aaa")))
    }
}
