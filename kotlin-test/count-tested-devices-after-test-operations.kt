package counttesteddevicesaftertestoperations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTestedDevicesAfterTestOperationsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.countTestedDevices(intArrayOf(1, 1, 2, 1, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.countTestedDevices(intArrayOf(0, 1, 2)))
    }

    @Test
    fun testSingleZero() {
        assertEquals(0, solution.countTestedDevices(intArrayOf(0)))
    }

    @Test
    fun testSinglePositive() {
        assertEquals(1, solution.countTestedDevices(intArrayOf(5)))
    }

    @Test
    fun testAllZeros() {
        assertEquals(0, solution.countTestedDevices(intArrayOf(0, 0, 0, 0)))
    }
}
