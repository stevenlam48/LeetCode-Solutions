package findthenumberofcopyarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfCopyArraysTest {
    @Test
    fun example1() {
        assertEquals(
            2,
            Solution().countArrays(
                intArrayOf(1, 2, 3, 4),
                arrayOf(
                    intArrayOf(1, 2), intArrayOf(2, 3),
                    intArrayOf(3, 4), intArrayOf(4, 5)
                )
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            2,
            Solution().countArrays(
                intArrayOf(1, 2, 3, 4),
                arrayOf(
                    intArrayOf(1, 2), intArrayOf(2, 3),
                    intArrayOf(3, 4), intArrayOf(4, 10)
                )
            )
        )
    }

    @Test
    fun example3() {
        assertEquals(
            0,
            Solution().countArrays(
                intArrayOf(1, 2, 1, 2),
                arrayOf(
                    intArrayOf(1, 1), intArrayOf(2, 3),
                    intArrayOf(3, 4), intArrayOf(1, 2)
                )
            )
        )
    }

    @Test
    fun singleElement() {
        assertEquals(
            3,
            Solution().countArrays(intArrayOf(5), arrayOf(intArrayOf(1, 3)))
        )
    }
}
