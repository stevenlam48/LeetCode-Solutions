package increasingtripletsubsequence

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IncreasingTripletSubsequenceTest {
    @Test
    fun example1() {
        assertTrue(Solution().increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun example2() {
        assertFalse(Solution().increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun example3() {
        assertTrue(Solution().increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))
    }

    @Test
    fun duplicates() {
        assertFalse(Solution().increasingTriplet(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun tooShort() {
        assertFalse(Solution().increasingTriplet(intArrayOf(1, 2)))
        assertFalse(Solution().increasingTriplet(intArrayOf(1)))
    }

    @Test
    fun nonAdjacentTriplet() {
        assertTrue(Solution().increasingTriplet(intArrayOf(20, 100, 10, 12, 5, 13)))
    }
}
