package findthemaximumlengthofvalidsubsequencei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumLengthOfValidSubsequenceITest {
    @Test
    fun alternatingParity() {
        assertEquals(4, Solution().maximumLength(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun mixedParityRuns() {
        assertEquals(6, Solution().maximumLength(intArrayOf(1, 2, 1, 1, 2, 1, 2)))
    }

    @Test
    fun allOdd() {
        assertEquals(3, Solution().maximumLength(intArrayOf(1, 3, 5)))
    }

    @Test
    fun allEven() {
        assertEquals(3, Solution().maximumLength(intArrayOf(2, 4, 6)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maximumLength(intArrayOf(1)))
    }
}
