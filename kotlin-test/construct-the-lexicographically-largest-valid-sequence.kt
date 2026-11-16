package constructthelexicographicallylargestvalidsequence

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConstructTheLexicographicallyLargestValidSequenceTest {
    @Test
    fun testN3() {
        assertArrayEquals(intArrayOf(3, 1, 2, 3, 2), Solution().constructDistancedSequence(3))
    }

    @Test
    fun testN5() {
        assertArrayEquals(
            intArrayOf(5, 3, 1, 4, 3, 5, 2, 4, 2),
            Solution().constructDistancedSequence(5)
        )
    }

    @Test
    fun testN1() {
        assertArrayEquals(intArrayOf(1), Solution().constructDistancedSequence(1))
    }

    @Test
    fun testN2() {
        assertArrayEquals(intArrayOf(2, 1, 2), Solution().constructDistancedSequence(2))
    }
}
