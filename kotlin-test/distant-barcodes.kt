package distantbarcodes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DistantBarcodesTest {
    private fun assertValid(input: IntArray, output: IntArray) {
        assertEquals(input.size, output.size)
        assertArrayEquals(input.sortedArray(), output.sortedArray())
        for (i in 1 until output.size) {
            assertNotEquals(output[i - 1], output[i])
        }
    }

    @Test
    fun testExample1() {
        val input = intArrayOf(1, 1, 1, 2, 2, 2)
        assertValid(input, Solution().rearrangeBarcodes(input))
    }

    @Test
    fun testExample2() {
        val input = intArrayOf(1, 1, 1, 1, 2, 2, 3, 3)
        assertValid(input, Solution().rearrangeBarcodes(input))
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(intArrayOf(5), Solution().rearrangeBarcodes(intArrayOf(5)))
    }

    @Test
    fun testTwoElements() {
        assertValid(intArrayOf(1, 2), Solution().rearrangeBarcodes(intArrayOf(1, 2)))
    }

    @Test
    fun testAllDistinct() {
        val input = intArrayOf(1, 2, 3, 4, 5)
        assertValid(input, Solution().rearrangeBarcodes(input))
    }
}
