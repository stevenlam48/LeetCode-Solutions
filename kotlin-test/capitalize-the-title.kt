package capitalizethetitle

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CapitalizeTheTitleTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("Capitalize The Title", solution.capitalizeTitle("capiTalIze tHe titLe"))
    }

    @Test
    fun testExample2() {
        assertEquals("First Letter of Each Word", solution.capitalizeTitle("First leTTeR of EACH Word"))
    }

    @Test
    fun testExample3() {
        assertEquals("i Love Leetcode", solution.capitalizeTitle("i lOve leetcode"))
    }

    @Test
    fun testSingleWord() {
        assertEquals("a", solution.capitalizeTitle("a"))
        assertEquals("Abc", solution.capitalizeTitle("abc"))
    }

    @Test
    fun testTwoLetterWords() {
        assertEquals("to be or Not to be", solution.capitalizeTitle("TO BE OR NOT TO BE"))
    }
}
