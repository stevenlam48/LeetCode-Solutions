package percentageofletterinstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PercentageOfLetterInStringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(33, solution.percentageLetter("foobar", 'o'))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.percentageLetter("jjjj", 'k'))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(100, solution.percentageLetter("a", 'a'))
    }

    @Test
    fun testRoundedDown() {
        assertEquals(16, solution.percentageLetter("sgawtb", 's'))
    }
}
