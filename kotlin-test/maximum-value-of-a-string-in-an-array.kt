package maximumvalueofastringinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValueOfAStringInAnArrayTest {
    @Test
    fun examples() {
        assertEquals(5, Solution().maximumValue(listOf("alic3", "bob", "3", "4", "00000")))
        assertEquals(1, Solution().maximumValue(listOf("1", "01", "001", "0001")))
    }

    @Test
    fun alphanumericValuesUseLength() {
        assertEquals(6, Solution().maximumValue(listOf("abcdef", "12x", "2")))
        assertEquals(2, Solution().maximumValue(listOf("-1")))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().maximumValue(emptyList()))
    }
}
