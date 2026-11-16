package studentattendancerecordi

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StudentAttendanceRecordITest {
    @Test
    fun `rewardable record`() {
        assertTrue(Solution().checkRecord("PPALLP"))
    }

    @Test
    fun `three consecutive late days`() {
        assertFalse(Solution().checkRecord("PPALLL"))
    }

    @Test
    fun `two absences`() {
        assertFalse(Solution().checkRecord("APPA"))
    }

    @Test
    fun `separated late days are allowed`() {
        assertTrue(Solution().checkRecord("LALL"))
    }
}
