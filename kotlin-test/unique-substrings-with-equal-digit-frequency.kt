package uniquesubstringswithequaldigitfrequency

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueSubstringsWithEqualDigitFrequencyTest {
    @Test
    fun repeatedAlternatingDigits() {
        assertEquals(5, Solution().equalDigitFrequency("1212"))
    }

    @Test
    fun palindromicDigits() {
        assertEquals(9, Solution().equalDigitFrequency("12321"))
    }

    @Test
    fun repeatedDigit() {
        assertEquals(4, Solution().equalDigitFrequency("112"))
    }

    @Test
    fun singleDigit() {
        assertEquals(1, Solution().equalDigitFrequency("7"))
    }
}
