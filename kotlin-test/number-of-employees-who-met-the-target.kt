package numberofemployeeswhometthetarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfEmployeesWhoMetTheTargetTest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().numberOfEmployeesWhoMetTarget(intArrayOf(0, 1, 2, 3, 4), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(0, Solution().numberOfEmployeesWhoMetTarget(intArrayOf(5, 1, 4, 2, 2), 6))
    }

    @Test
    fun testSingleEmployee() {
        assertEquals(1, Solution().numberOfEmployeesWhoMetTarget(intArrayOf(1), 1))
    }
}
