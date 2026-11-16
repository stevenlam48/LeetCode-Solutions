package sumofbeautyofallsubstrings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfBeautyOfAllSubstringsTest {
    @Test
    fun exampleOne() {
        assertEquals(5, Solution().beautySum("aabcb"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(17, Solution().beautySum("aabcbaa"))
    }

    @Test
    fun allIdenticalCharacters() {
        assertEquals(0, Solution().beautySum("aaaa"))
    }

    @Test
    fun shortAndEmptyInputs() {
        assertEquals(0, Solution().beautySum(""))
        assertEquals(0, Solution().beautySum("a"))
        assertEquals(2, Solution().beautySum("abba"))
    }
}
