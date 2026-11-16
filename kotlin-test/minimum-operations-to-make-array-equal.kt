package minimumoperationstomakearrayequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayEqualTest {
    @Test
    fun testSingleElement() {
        assertEquals(0, Solution().minOperations(1))
    }

    @Test
    fun testTwoElements() {
        assertEquals(1, Solution().minOperations(2))
    }

    @Test
    fun testOddLength() {
        assertEquals(12, Solution().minOperations(7))
    }

    @Test
    fun testEvenLength() {
        assertEquals(16, Solution().minOperations(8))
    }
}
