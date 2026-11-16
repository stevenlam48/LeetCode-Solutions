package beforeandafterpuzzle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BeforeAndAfterPuzzleTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(
            listOf("writing code rocks"),
            solution.beforeAndAfterPuzzles(arrayOf("writing code", "code rocks"))
        )
    }

    @Test
    fun secondExample() {
        assertEquals(
            listOf(
                "a chip off the old block party",
                "a man on a mission impossible",
                "a man on a mission statement",
                "a quick bite to eat my words",
                "chocolate bar of soap"
            ),
            solution.beforeAndAfterPuzzles(
                arrayOf(
                    "mission statement",
                    "a quick bite to eat",
                    "a chip off the old block",
                    "chocolate bar",
                    "mission impossible",
                    "a man on a mission",
                    "block party",
                    "eat my words",
                    "bar of soap"
                )
            )
        )
    }

    @Test
    fun removesDuplicateResults() {
        assertEquals(
            listOf("a b c"),
            solution.beforeAndAfterPuzzles(arrayOf("a b", "b c", "b c"))
        )
    }

    @Test
    fun joinsInBothDirections() {
        assertEquals(
            listOf("a b a", "b a b"),
            solution.beforeAndAfterPuzzles(arrayOf("a b", "b a"))
        )
    }

    @Test
    fun cannotJoinPhraseWithItself() {
        assertEquals(
            emptyList<String>(),
            solution.beforeAndAfterPuzzles(arrayOf("writing code"))
        )
    }
}
