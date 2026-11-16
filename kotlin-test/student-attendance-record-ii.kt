package studentattendancerecordii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StudentAttendanceRecordIiTest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().checkRecord(1))
    }

    @Test
    fun testExample2() {
        assertEquals(8, Solution().checkRecord(2))
    }

    @Test
    fun testExample3() {
        assertEquals(19, Solution().checkRecord(3))
    }

    @Test
    fun testLarger() {
        assertEquals(43, Solution().checkRecord(4))
    }

    @Test
    fun testLargeValue() {
        assertEquals(749184020, Solution().checkRecord(100000))
    }
}
