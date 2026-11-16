package flippinganimage

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FlippingAnImageTest {
    @Test
    fun oddWidthExample() {
        val image = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0)
        )
        val expected = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
        assertArrayEquals(expected, Solution().flipAndInvertImage(image))
    }

    @Test
    fun evenWidthExample() {
        val image = arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 0, 0, 1),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 0, 1, 0)
        )
        val expected = arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 0, 0, 1),
            intArrayOf(1, 0, 1, 0)
        )
        assertArrayEquals(expected, Solution().flipAndInvertImage(image))
    }

    @Test
    fun singleElement() {
        val image = arrayOf(intArrayOf(1))
        val expected = arrayOf(intArrayOf(0))
        assertArrayEquals(expected, Solution().flipAndInvertImage(image))
    }

    @Test
    fun emptyImage() {
        val image = arrayOf<IntArray>()
        assertArrayEquals(arrayOf<IntArray>(), Solution().flipAndInvertImage(image))
    }
}
