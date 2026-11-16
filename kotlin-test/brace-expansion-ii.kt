package braceexpansionii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BraceExpansionIiTest {
    @Test
    fun example1() {
        assertEquals(
            listOf("ac", "ad", "ae", "bc", "bd", "be"),
            Solution().braceExpansionII("{a,b}{c,{d,e}}")
        )
    }

    @Test
    fun example2() {
        assertEquals(
            listOf("a", "ab", "ac", "z"),
            Solution().braceExpansionII("{{a,z},a{b,c},{ab,z}}")
        )
    }

    @Test
    fun concatenation() {
        assertEquals(
            listOf("acdf", "acef", "bcdf", "bcef"),
            Solution().braceExpansionII("{a,b}c{d,e}f")
        )
    }

    @Test
    fun plainWord() {
        assertEquals(listOf("abc"), Solution().braceExpansionII("abc"))
    }
}
