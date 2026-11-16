package checkifawordoccursasaprefixofanywordinasentence

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAWordOccursAsAPrefixOfAnyWordInASentenceTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.isPrefixOfWord("i love eating burger", "burg"))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.isPrefixOfWord("this problem is an easy problem", "pro"))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, solution.isPrefixOfWord("i am tired", "you"))
    }

    @Test
    fun testFirstWord() {
        assertEquals(1, solution.isPrefixOfWord("hello world", "hel"))
    }

    @Test
    fun testNotAPrefix() {
        assertEquals(-1, solution.isPrefixOfWord("hellohello hellohellohello", "ell"))
    }

    @Test
    fun testSecondWord() {
        assertEquals(2, solution.isPrefixOfWord("b burger", "burg"))
    }
}
