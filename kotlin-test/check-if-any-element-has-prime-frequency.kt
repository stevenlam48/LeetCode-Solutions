package checkifanyelementhasprimefrequency

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAnyElementHasPrimeFrequencyTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.checkPrimeFrequency(intArrayOf(1, 2, 3, 4, 5, 4)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.checkPrimeFrequency(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.checkPrimeFrequency(intArrayOf(2, 2, 2, 3, 3, 3)))
    }

    @Test
    fun testSingleElement() {
        assertFalse(solution.checkPrimeFrequency(intArrayOf(7)))
    }

    @Test
    fun testCompositeFrequency() {
        assertFalse(solution.checkPrimeFrequency(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testTwoPrimeFrequencies() {
        assertTrue(solution.checkPrimeFrequency(intArrayOf(2, 2, 3, 3, 3)))
    }
}
