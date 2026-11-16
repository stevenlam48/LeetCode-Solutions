package countnondecreasingarrayswithgivendigitsums

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNonDecreasingArraysWithGivenDigitSumsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(10, solution.countArrays(intArrayOf(1, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(30, solution.countArrays(intArrayOf(1, 2)))
    }

    @Test
    fun testSameDigitSum() {
        assertEquals(55, solution.countArrays(intArrayOf(2, 2)))
    }

    @Test
    fun testThreeElements() {
        assertEquals(20, solution.countArrays(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testLargerDigitSum() {
        assertEquals(210, solution.countArrays(intArrayOf(3, 3)))
    }

    @Test
    fun testMixed() {
        assertEquals(346, solution.countArrays(intArrayOf(1, 2, 3)))
    }
}
