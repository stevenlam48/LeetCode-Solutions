package constructstringwithminimumcosteasy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructStringWithMinimumCostEasyTest {
    @Test
    fun testExample1() {
        assertEquals(
            7,
            Solution().minimumCost(
                "abcdef",
                listOf("abdef", "abc", "d", "def", "ef"),
                intArrayOf(100, 1, 1, 10, 5)
            )
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            -1,
            Solution().minimumCost(
                "aaaa",
                listOf("z", "zz", "zzz"),
                intArrayOf(1, 10, 100)
            )
        )
    }

    @Test
    fun testExample3() {
        assertEquals(
            2,
            Solution().minimumCost(
                "cdcd",
                listOf("c", "d", "cd"),
                intArrayOf(1, 1, 1)
            )
        )
    }

    @Test
    fun testDuplicateWordCheapestWins() {
        assertEquals(
            2,
            Solution().minimumCost(
                "abc",
                listOf("abc", "abc"),
                intArrayOf(5, 2)
            )
        )
    }

    @Test
    fun testSingleCharacterTarget() {
        assertEquals(
            3,
            Solution().minimumCost("a", listOf("a"), intArrayOf(3))
        )
    }
}
