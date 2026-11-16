package maximumnumberofballoons

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfBalloonsTest {
    private val solution = Solution()

    @Test
    fun oneInstance() {
        assertEquals(1, solution.maxNumberOfBalloons("nlaebolko"))
    }

    @Test
    fun twoInstances() {
        assertEquals(2, solution.maxNumberOfBalloons("loonbalxballpoon"))
    }

    @Test
    fun noInstance() {
        assertEquals(0, solution.maxNumberOfBalloons("leetcode"))
    }

    @Test
    fun exactWord() {
        assertEquals(1, solution.maxNumberOfBalloons("balloon"))
    }

    @Test
    fun doubledWord() {
        assertEquals(2, solution.maxNumberOfBalloons("balloonballoon"))
    }

    @Test
    fun missingLetter() {
        assertEquals(0, solution.maxNumberOfBalloons("balon"))
    }
}
