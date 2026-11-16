package reverselettersthenspecialcharactersinastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseLettersThenSpecialCharactersInAStringTest {
    @Test
    fun example1() {
        assertEquals("cba321", Solution().reverseByType("abc123"))
    }

    @Test
    fun example2() {
        assertEquals("j-Ih-gfE-dCba", Solution().reverseByType("a-bC-dEf-ghIj"))
    }

    @Test
    fun example3() {
        assertEquals("Qedo!ct-eeLg=ntse-T1", Solution().reverseByType("Test1ng-Leet=code-Q!"))
    }

    @Test
    fun onlyLetters() {
        assertEquals("bA", Solution().reverseByType("Ab"))
    }

    @Test
    fun onlySpecialCharacters() {
        assertEquals("+1", Solution().reverseByType("1+"))
    }

    @Test
    fun singleLetterAndDigit() {
        assertEquals("a1", Solution().reverseByType("a1"))
    }
}
