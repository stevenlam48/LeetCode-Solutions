package primesubtractionoperation

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PrimeSubtractionOperationTest {
    @Test
    fun exampleOne() {
        assertTrue(Solution().primeSubOperation(intArrayOf(4, 9, 6, 10)))
    }

    @Test
    fun exampleTwo() {
        assertTrue(Solution().primeSubOperation(intArrayOf(6, 8, 11, 12)))
    }

    @Test
    fun exampleThree() {
        assertFalse(Solution().primeSubOperation(intArrayOf(5, 8, 3)))
    }

    @Test
    fun equalPair() {
        assertFalse(Solution().primeSubOperation(intArrayOf(2, 2)))
    }

    @Test
    fun singleElement() {
        assertTrue(Solution().primeSubOperation(intArrayOf(1)))
    }

    @Test
    fun increasingSequence() {
        assertTrue(Solution().primeSubOperation(intArrayOf(1, 2, 3, 4, 5)))
    }
}
