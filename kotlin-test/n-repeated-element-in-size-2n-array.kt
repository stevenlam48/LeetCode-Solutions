package nrepeatedelementinsize2narray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NRepeatedElementInSize2NArrayTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().repeatedNTimes(intArrayOf(1, 2, 3, 3)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().repeatedNTimes(intArrayOf(2, 1, 2, 5, 3, 2)))
    }

    @Test
    fun example3() {
        assertEquals(5, Solution().repeatedNTimes(intArrayOf(5, 1, 5, 2, 5, 3, 5, 4)))
    }

    @Test
    fun twoElements() {
        assertEquals(1, Solution().repeatedNTimes(intArrayOf(1, 1)))
    }

    @Test
    fun repeatedAtEnds() {
        assertEquals(1, Solution().repeatedNTimes(intArrayOf(1, 2, 1)))
    }
}
