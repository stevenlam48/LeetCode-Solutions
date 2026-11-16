package pancakesorting

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PancakeSortingTest {
    private fun applyFlips(arr: IntArray, flips: IntArray): IntArray {
        val a = arr.copyOf()
        for (k in flips) {
            assertTrue(k in 1..a.size, "flip length out of range: $k")
            var i = 0
            var j = k - 1
            while (i < j) {
                val tmp = a[i]
                a[i] = a[j]
                a[j] = tmp
                i++
                j--
            }
        }
        return a
    }

    private fun assertSorts(arr: IntArray) {
        val flips = Solution().pancakeSort(arr)
        assertTrue(flips.size <= 10 * arr.size)
        assertArrayEquals(arr.sortedArray(), applyFlips(arr, flips))
    }

    @Test
    fun testAlreadySorted() {
        assertEquals(0, Solution().pancakeSort(intArrayOf(1, 2, 3)).size)
    }

    @Test
    fun testReverseOrder() {
        assertArrayEquals(intArrayOf(2, 2, 3), Solution().pancakeSort(intArrayOf(3, 2, 1)))
    }

    @Test
    fun testExample() {
        assertSorts(intArrayOf(3, 2, 4, 1))
    }

    @Test
    fun testSingleElement() {
        assertSorts(intArrayOf(1))
    }

    @Test
    fun testSmallPermutation() {
        assertSorts(intArrayOf(4, 1, 3, 2))
    }

    @Test
    fun testLargerPermutation() {
        assertSorts(intArrayOf(5, 4, 3, 2, 1, 6, 7))
    }
}
