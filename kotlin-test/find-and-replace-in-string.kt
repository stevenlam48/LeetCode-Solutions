package findandreplaceinstring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindAndReplaceInStringTest {
    @Test
    fun twoReplacements() {
        assertEquals(
            "eeebffff",
            Solution().findReplaceString(
                "abcd",
                intArrayOf(0, 2),
                listOf("a", "cd"),
                listOf("eee", "ffff")
            )
        )
    }

    @Test
    fun failedMatchDoesNotBlockLaterMatch() {
        assertEquals(
            "eeecd",
            Solution().findReplaceString(
                "abcd",
                intArrayOf(0, 2),
                listOf("ab", "ec"),
                listOf("eee", "ffff")
            )
        )
    }

    @Test
    fun unmatchedSourcesLeaveStringUnchanged() {
        assertEquals(
            "vbfrsggqzp",
            Solution().findReplaceString(
                "vmokgggqzp",
                intArrayOf(3, 4, 1),
                listOf("kg", "ggq", "mo"),
                listOf("s", "so", "bfr")
            )
        )
    }
}
