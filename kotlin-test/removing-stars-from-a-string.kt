package removingstarsfromastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemovingStarsFromAStringTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals("lecoe", solution.removeStars("leet**cod*e"))
    }

    @Test
    fun allCharactersCanBeRemoved() {
        assertEquals("", solution.removeStars("erase*****"))
    }

    @Test
    fun stringWithoutStarsIsUnchanged() {
        assertEquals("abc", solution.removeStars("abc"))
    }

    @Test
    fun starsCanRemoveFromDifferentSegments() {
        assertEquals("c", solution.removeStars("ab**cd*"))
    }
}
