package findthexorofnumberswhichappeartwice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheXorOfNumbersWhichAppearTwiceTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.duplicateNumbersXOR(intArrayOf(1, 2, 1, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.duplicateNumbersXOR(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testMultipleDuplicates() {
        assertEquals(3, solution.duplicateNumbersXOR(intArrayOf(1, 2, 2, 1)))
    }

    @Test
    fun testSingleDuplicatePair() {
        assertEquals(5, solution.duplicateNumbersXOR(intArrayOf(5, 5)))
    }

    @Test
    fun testLargerRange() {
        assertEquals(7, solution.duplicateNumbersXOR(intArrayOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 6)))
    }
}
