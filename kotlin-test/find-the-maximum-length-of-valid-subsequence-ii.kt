package findthemaximumlengthofvalidsubsequenceii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumLengthOfValidSubsequenceIITest {
    @Test
    fun alternatingParityModuloTwo() {
        assertEquals(5, Solution().maximumLength(intArrayOf(1, 2, 3, 4, 5), 2))
    }

    @Test
    fun moduloThree() {
        assertEquals(4, Solution().maximumLength(intArrayOf(1, 4, 2, 3, 1, 4), 3))
    }

    @Test
    fun moduloOne() {
        assertEquals(3, Solution().maximumLength(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun equalValues() {
        assertEquals(4, Solution().maximumLength(intArrayOf(7, 7, 7, 7), 5))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maximumLength(intArrayOf(1), 5))
    }
}
