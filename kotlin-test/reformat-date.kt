package reformatdate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReformatDateTest {
    @Test
    fun twoDigitDay() {
        assertEquals("2052-10-20", Solution().reformatDate("20th Oct 2052"))
    }

    @Test
    fun oneDigitDay() {
        assertEquals("1933-06-06", Solution().reformatDate("6th Jun 1933"))
    }

    @Test
    fun yearWithLeadingZero() {
        assertEquals("0026-05-26", Solution().reformatDate("26th May 0026"))
    }

    @Test
    fun december() {
        assertEquals("1999-12-01", Solution().reformatDate("1st Dec 1999"))
    }
}
