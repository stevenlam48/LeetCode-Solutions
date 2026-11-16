package minimumdistancetotypeawordusingtwofingers
// Time:  O(26n)
// Space: O(26)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDistanceToTypeAWordUsingTwoFingersTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(3, solution.minimumDistance("CAKE"))
        assertEquals(6, solution.minimumDistance("HAPPY"))
        assertEquals(3, solution.minimumDistance("NEW"))
        assertEquals(7, solution.minimumDistance("YEAR"))
    }

    @Test
    fun emptyAndSingleLetterWords() {
        assertEquals(0, solution.minimumDistance(""))
        assertEquals(0, solution.minimumDistance("Z"))
    }

    @Test
    fun repeatedLettersNeedNoMovement() {
        assertEquals(0, solution.minimumDistance("AAAAAA"))
    }
}
