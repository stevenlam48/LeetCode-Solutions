package braceexpansion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BraceExpansionTest {
    @Test
    fun example1() {
        assertEquals(
            listOf("acdf", "acef", "bcdf", "bcef"),
            Solution().expand("{a,b}c{d,e}f")
        )
    }

    @Test
    fun noBraces() {
        assertEquals(listOf("abcd"), Solution().expand("abcd"))
    }

    @Test
    fun twoGroups() {
        assertEquals(
            listOf("ax", "ay", "az", "bx", "by", "bz"),
            Solution().expand("{a,b}{z,x,y}")
        )
    }

    @Test
    fun nested() {
        assertEquals(listOf("a", "bc", "bd"), Solution().expand("{a,b{c,d}}"))
    }

    @Test
    fun singleOption() {
        assertEquals(listOf("a"), Solution().expand("{a}"))
    }
}
