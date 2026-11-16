package numberofsubstringscontainingallthreecharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubstringsContainingAllThreeCharactersTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(10, solution.numberOfSubstrings("abcabc"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, solution.numberOfSubstrings("aaacb"))
    }

    @Test
    fun exampleThree() {
        assertEquals(1, solution.numberOfSubstrings("abc"))
    }

    @Test
    fun withoutAllCharacters() {
        assertEquals(0, solution.numberOfSubstrings(""))
        assertEquals(0, solution.numberOfSubstrings("aaaa"))
    }
}
