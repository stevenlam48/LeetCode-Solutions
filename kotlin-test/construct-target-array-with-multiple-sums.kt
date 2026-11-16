package constructtargetarraywithmultiplesums

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConstructTargetArrayWithMultipleSumsTest {
    @Test
    fun testExample1() {
        assertTrue(Solution().isPossible(intArrayOf(9, 3, 5)))
    }

    @Test
    fun testExample2() {
        assertFalse(Solution().isPossible(intArrayOf(1, 1, 1, 2)))
    }

    @Test
    fun testExample3() {
        assertTrue(Solution().isPossible(intArrayOf(8, 5)))
    }

    @Test
    fun testSingleOne() {
        assertTrue(Solution().isPossible(intArrayOf(1)))
    }

    @Test
    fun testLargeValue() {
        assertTrue(Solution().isPossible(intArrayOf(1, 1000000000)))
    }

    @Test
    fun testAllOnes() {
        assertTrue(Solution().isPossible(intArrayOf(1, 1, 1)))
    }
}
