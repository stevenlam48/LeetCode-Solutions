package minimumoperationstoequalizebinarystring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToEqualizeBinaryStringTest {

    @Test
    fun testSingleFlip() {
        assertEquals(1, Solution().minOperations("110", 1))
    }

    @Test
    fun testMultipleZerosInOneFlip() {
        assertEquals(1, Solution().minOperations("010", 2))
    }

    @Test
    fun testAlreadyAllOnes() {
        assertEquals(0, Solution().minOperations("1111", 2))
    }

    @Test
    fun testTwoOperations() {
        assertEquals(2, Solution().minOperations("0000", 2))
    }

    @Test
    fun testThreeOperations() {
        assertEquals(3, Solution().minOperations("000000", 4))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, Solution().minOperations("00000", 2))
    }

    @Test
    fun testWholeStringFlip() {
        assertEquals(1, Solution().minOperations("0", 1))
        assertEquals(0, Solution().minOperations("1", 1))
    }
}
