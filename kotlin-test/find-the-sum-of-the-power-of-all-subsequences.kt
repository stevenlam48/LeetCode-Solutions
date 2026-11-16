package findthesumofthepowerofallsubsequences

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheSumOfThePowerOfAllSubsequencesTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.sumOfPower(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.sumOfPower(intArrayOf(2, 3, 3), 5))
    }

    @Test
    fun testRepeatedOnes() {
        assertEquals(6, solution.sumOfPower(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.sumOfPower(intArrayOf(5), 5))
        assertEquals(0, solution.sumOfPower(intArrayOf(5), 3))
    }

    @Test
    fun testElementLargerThanK() {
        assertEquals(0, solution.sumOfPower(intArrayOf(10, 20), 5))
    }
}
