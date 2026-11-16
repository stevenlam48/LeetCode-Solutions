package linereflection
// Time:  O(n)
// Space: O(n)

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LineReflectionTest {
    @Test
    fun acceptsFirstLeetCodeExample() {
        assertTrue(Solution().isReflected(arrayOf(1 to 1, -1 to 1)))
    }

    @Test
    fun rejectsSecondLeetCodeExample() {
        assertFalse(Solution().isReflected(arrayOf(1 to 1, -1 to -1)))
    }

    @Test
    fun ignoresDuplicatePoints() {
        assertTrue(Solution().isReflected(arrayOf(1 to 1, 1 to 1, -1 to 1, -1 to 1)))
    }

    @Test
    fun acceptsEmptyPoints() {
        assertTrue(Solution().isReflected(emptyArray()))
    }

    @Test
    fun checksReflectionSeparatelyAtEachY() {
        assertTrue(Solution().isReflected(arrayOf(1 to 1, -1 to 1, 0 to 2)))
        assertFalse(Solution().isReflected(arrayOf(1 to 1, -1 to 1, 2 to 2, 0 to 2)))
    }
}
