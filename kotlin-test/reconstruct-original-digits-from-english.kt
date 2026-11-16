package reconstructoriginaldigitsfromenglish

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReconstructOriginalDigitsFromEnglishTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("012", solution.originalDigits("owoztneoer"))
    }

    @Test
    fun testExample2() {
        assertEquals("45", solution.originalDigits("fviefuro"))
    }

    @Test
    fun testSingleDigit() {
        assertEquals("0", solution.originalDigits("zero"))
        assertEquals("9", solution.originalDigits("nine"))
    }

    @Test
    fun testRepeatedDigits() {
        assertEquals("00", solution.originalDigits("zerozero"))
        assertEquals("11", solution.originalDigits("oneone"))
    }

    @Test
    fun testAllDigits() {
        val text = "zeroonetwothreefourfivesixseveneightnine"
        assertEquals("0123456789", solution.originalDigits(text))
    }

    @Test
    fun testEmpty() {
        assertEquals("", solution.originalDigits(""))
    }
}
