package reformatphonenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReformatPhoneNumberTest {
    @Test
    fun sixDigits() {
        assertEquals("123-456", Solution().reformatNumber("1-23-45 6"))
    }

    @Test
    fun finalGroupOfTwo() {
        assertEquals("123-45-67", Solution().reformatNumber("123 4-567"))
    }

    @Test
    fun finalGroupOfOneIsRegrouped() {
        assertEquals("123-456-78", Solution().reformatNumber("123 4-5678"))
    }

    @Test
    fun separatorsOnlyAroundTwoDigits() {
        assertEquals("12", Solution().reformatNumber("--12"))
    }

    @Test
    fun emptyInput() {
        assertEquals("", Solution().reformatNumber(""))
    }
}
