package smallestintegerdivisiblebyk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestIntegerDivisibleByKTest {
    private val solution = Solution()

    @Test
    fun testOne() {
        assertEquals(1, solution.smallestRepunitDivByK(1))
    }

    @Test
    fun testEvenIsImpossible() {
        assertEquals(-1, solution.smallestRepunitDivByK(2))
    }

    @Test
    fun testThree() {
        assertEquals(3, solution.smallestRepunitDivByK(3))
    }

    @Test
    fun testFiveIsImpossible() {
        assertEquals(-1, solution.smallestRepunitDivByK(5))
    }

    @Test
    fun testSeven() {
        assertEquals(6, solution.smallestRepunitDivByK(7))
    }

    @Test
    fun testEleven() {
        assertEquals(2, solution.smallestRepunitDivByK(11))
    }
}
