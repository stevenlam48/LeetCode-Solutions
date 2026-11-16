package convertdatetobinary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertDateToBinaryTest {
    @Test
    fun leapDay() {
        assertEquals("100000100000-10-11101", Solution().convertDateToBinary("2080-02-29"))
    }

    @Test
    fun firstDayOfNineteenHundred() {
        assertEquals("11101101100-1-1", Solution().convertDateToBinary("1900-01-01"))
    }

    @Test
    fun novemberTwelfth() {
        assertEquals("11111101000-1011-1100", Solution().convertDateToBinary("2024-11-12"))
    }
}
