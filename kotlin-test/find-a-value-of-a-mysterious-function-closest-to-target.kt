package findavalueofamysteriousfunctionclosesttotarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAValueOfAMysteriousFunctionClosestToTargetTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().closestToTarget(intArrayOf(9, 12, 3, 7, 15), 5))
    }

    @Test
    fun example2() {
        assertEquals(999999, Solution().closestToTarget(intArrayOf(1000000, 1000000, 1000000), 1))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().closestToTarget(intArrayOf(1, 2, 4, 8, 16), 0))
    }

    @Test
    fun singleElementExactMatch() {
        assertEquals(0, Solution().closestToTarget(intArrayOf(5), 5))
    }

    @Test
    fun singleElementNoMatch() {
        assertEquals(2, Solution().closestToTarget(intArrayOf(5), 3))
    }

    @Test
    fun twoElements() {
        assertEquals(1, Solution().closestToTarget(intArrayOf(1, 2), 3))
    }
}
