package findinmountainarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindInMountainArrayTest {
    private class ArrayBackedMountainArray(private val values: IntArray) : MountainArray {
        override fun get(index: Int): Int = values[index]

        override fun length(): Int = values.size
    }

    @Test
    fun findsTargetOnAscendingSide() {
        val mountain = ArrayBackedMountainArray(intArrayOf(1, 2, 3, 4, 5, 3, 1))

        assertEquals(2, Solution().findInMountainArray(3, mountain))
    }

    @Test
    fun findsTargetOnDescendingSide() {
        val mountain = ArrayBackedMountainArray(intArrayOf(0, 5, 4, 3, 2))

        assertEquals(2, Solution().findInMountainArray(4, mountain))
        assertEquals(4, Solution().findInMountainArray(2, mountain))
    }

    @Test
    fun returnsLeftmostOccurrence() {
        val mountain = ArrayBackedMountainArray(intArrayOf(1, 5, 2))

        assertEquals(0, Solution().findInMountainArray(1, mountain))
    }

    @Test
    fun returnsMinusOneWhenTargetIsAbsent() {
        val mountain = ArrayBackedMountainArray(intArrayOf(1, 2, 3, 4, 5, 3, 1))

        assertEquals(-1, Solution().findInMountainArray(6, mountain))
    }
}
