package findtheminimumpossiblesumofabeautifularray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMinimumPossibleSumOfABeautifulArrayTest {
    @Test
    fun example1() {
        assertEquals(4L, Solution().minimumPossibleSum(2, 3))
    }

    @Test
    fun example2() {
        assertEquals(8L, Solution().minimumPossibleSum(3, 3))
    }

    @Test
    fun example3() {
        assertEquals(1L, Solution().minimumPossibleSum(1, 1))
    }

    @Test
    fun largeTarget() {
        assertEquals(10L, Solution().minimumPossibleSum(4, 10))
    }
}
