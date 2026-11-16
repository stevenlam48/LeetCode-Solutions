package comparesumsofbitonicparts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CompareSumsOfBitonicPartsTest {
    private val solution = Solution()

    @Test
    fun testIncreasing() {
        assertEquals(0, solution.compareBitonicSums(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testDecreasing() {
        assertEquals(1, solution.compareBitonicSums(intArrayOf(3, 2, 1)))
    }

    @Test
    fun testFlat() {
        assertEquals(-1, solution.compareBitonicSums(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testEqualSums() {
        assertEquals(-1, solution.compareBitonicSums(intArrayOf(1, 2, 2, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(-1, solution.compareBitonicSums(intArrayOf(5)))
    }

    @Test
    fun testBitonic() {
        assertEquals(0, solution.compareBitonicSums(intArrayOf(2, 3, 1)))
    }
}
