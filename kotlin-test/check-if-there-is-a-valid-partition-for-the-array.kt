package checkifthereisavalidpartitionforthearray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfThereIsAValidPartitionForTheArrayTest {
    private val solution = Solution()

    @Test
    fun testTripleAndPair() {
        assertTrue(solution.validPartition(intArrayOf(4, 4, 4, 5, 6)))
    }

    @Test
    fun testNoValidPartition() {
        assertFalse(solution.validPartition(intArrayOf(1, 1, 1, 2)))
    }

    @Test
    fun testTwoPairs() {
        assertTrue(solution.validPartition(intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun testConsecutiveLeftover() {
        assertFalse(solution.validPartition(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testSingleElement() {
        assertFalse(solution.validPartition(intArrayOf(1)))
    }

    @Test
    fun testConsecutiveTriple() {
        assertTrue(solution.validPartition(intArrayOf(1, 2, 3)))
    }
}
