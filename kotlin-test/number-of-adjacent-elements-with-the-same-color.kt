package numberofadjacentelementswiththesamecolor

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfAdjacentElementsWithTheSameColorTest {
    @Test
    fun example1() {
        val queries = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 2),
            intArrayOf(3, 1),
            intArrayOf(1, 1),
            intArrayOf(2, 1),
        )
        assertArrayEquals(intArrayOf(0, 1, 1, 0, 2), Solution().colorTheArray(4, queries))
    }

    @Test
    fun singleElement() {
        val queries = arrayOf(intArrayOf(0, 100000))
        assertArrayEquals(intArrayOf(0), Solution().colorTheArray(1, queries))
    }

    @Test
    fun twoElements() {
        val queries = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 1),
        )
        assertArrayEquals(intArrayOf(0, 1), Solution().colorTheArray(2, queries))
    }

    @Test
    fun overwriteMiddle() {
        val queries = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(1, 2),
        )
        assertArrayEquals(intArrayOf(0, 1, 2, 0), Solution().colorTheArray(3, queries))
    }
}
