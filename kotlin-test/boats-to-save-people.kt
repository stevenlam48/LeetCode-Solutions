package boatstosavepeople

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BoatsToSavePeopleTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().numRescueBoats(intArrayOf(1, 2), 3))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().numRescueBoats(intArrayOf(3, 2, 2, 1), 3))
    }

    @Test
    fun example3() {
        assertEquals(4, Solution().numRescueBoats(intArrayOf(3, 5, 3, 4), 5))
    }

    @Test
    fun singlePerson() {
        assertEquals(1, Solution().numRescueBoats(intArrayOf(1), 1))
    }

    @Test
    fun allPairUp() {
        assertEquals(2, Solution().numRescueBoats(intArrayOf(1, 1, 1, 1), 2))
    }
}
