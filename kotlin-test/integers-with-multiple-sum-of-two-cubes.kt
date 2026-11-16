package integerswithmultiplesumoftwocubes

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class IntegersWithMultipleSumOfTwoCubesTest {
    @Test
    fun returnsEmptyBelowFirstGoodInteger() {
        assertArrayEquals(IntArray(0), Solution().findGoodIntegers(1))
        assertArrayEquals(IntArray(0), Solution().findGoodIntegers(1728))
    }

    @Test
    fun findsFirstTaxicabNumber() {
        assertArrayEquals(intArrayOf(1729), Solution().findGoodIntegers(1729))
    }

    @Test
    fun returnsGoodIntegersInSortedOrder() {
        assertArrayEquals(intArrayOf(1729, 4104), Solution().findGoodIntegers(4104))
    }
}
