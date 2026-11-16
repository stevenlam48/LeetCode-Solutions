package reversedegreeofastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseDegreeOfAStringTest {
    @Test
    fun example1() {
        assertEquals(148, Solution().reverseDegree("abc"))
    }

    @Test
    fun example2() {
        assertEquals(160, Solution().reverseDegree("zaza"))
    }

    @Test
    fun singleFirstLetter() {
        assertEquals(26, Solution().reverseDegree("a"))
    }

    @Test
    fun singleLastLetter() {
        assertEquals(1, Solution().reverseDegree("z"))
    }

    @Test
    fun twoLetters() {
        assertEquals(28, Solution().reverseDegree("az"))
    }
}
