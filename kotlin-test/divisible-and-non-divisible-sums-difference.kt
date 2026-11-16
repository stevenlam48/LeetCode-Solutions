package divisibleandnondivisiblesumsdifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivisibleAndNonDivisibleSumsDifferenceTest {
    @Test
    fun example1() {
        assertEquals(19, Solution().differenceOfSums(10, 3))
    }

    @Test
    fun example2() {
        assertEquals(15, Solution().differenceOfSums(5, 6))
    }

    @Test
    fun example3() {
        assertEquals(-15, Solution().differenceOfSums(5, 1))
    }

    @Test
    fun singleValue() {
        assertEquals(1, Solution().differenceOfSums(1, 2))
    }
}
