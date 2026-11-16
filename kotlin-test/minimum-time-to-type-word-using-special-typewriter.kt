package minimumtimetotypewordusingspecialtypewriter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToTypeWordUsingSpecialTypewriterTest {
    @Test
    fun clockwiseMovement() {
        assertEquals(5, Solution().minTimeToType("abc"))
    }

    @Test
    fun wrapAroundMovement() {
        assertEquals(7, Solution().minTimeToType("bza"))
    }

    @Test
    fun alternatingDirections() {
        assertEquals(34, Solution().minTimeToType("zjpc"))
    }

    @Test
    fun initialCharacter() {
        assertEquals(1, Solution().minTimeToType("a"))
    }

    @Test
    fun emptyWord() {
        assertEquals(0, Solution().minTimeToType(""))
    }
}
