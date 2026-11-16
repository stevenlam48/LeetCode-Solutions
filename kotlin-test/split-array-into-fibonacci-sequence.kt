package splitarrayintofibonaccisequence

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SplitArrayIntoFibonacciSequenceTest {
    @Test
    fun twoDigitFibonacciSequence() {
        assertArrayEquals(intArrayOf(123, 456, 579), Solution().splitIntoFibonacci("123456579"))
    }

    @Test
    fun severalSingleAndMultiDigitTerms() {
        assertArrayEquals(intArrayOf(1, 1, 2, 3, 5, 8, 13), Solution().splitIntoFibonacci("11235813"))
    }

    @Test
    fun incompleteFinalTermReturnsEmpty() {
        assertArrayEquals(intArrayOf(), Solution().splitIntoFibonacci("112358130"))
    }

    @Test
    fun validSequenceContainingZero() {
        assertArrayEquals(intArrayOf(11, 0, 11, 11), Solution().splitIntoFibonacci("1101111"))
    }

    @Test
    fun allZeroesFormThreeTermSequence() {
        assertArrayEquals(intArrayOf(0, 0, 0, 0), Solution().splitIntoFibonacci("0000"))
    }
}
