package findarraygivensubsetsums

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindArrayGivenSubsetSumsTest {
    @Test
    fun singleElementArray() {
        assertArrayEquals(intArrayOf(5), Solution().recoverArray(1, intArrayOf(0, 5)))
    }

    @Test
    fun standardExampleWithNegativeElement() {
        assertRecovered(intArrayOf(-3, -2, -1, 0, 0, 1, 2, 3), 3)
    }

    @Test
    fun multipleNegativeAndPositiveElements() {
        assertRecovered(intArrayOf(-4, -2, -1, 0, 1, 2, 3, 5), 3)
    }

    @Test
    fun zeroArrayWithDuplicateSums() {
        assertArrayEquals(intArrayOf(0, 0), Solution().recoverArray(2, intArrayOf(0, 0, 0, 0)))
    }

    private fun assertRecovered(input: IntArray, n: Int) {
        val result = Solution().recoverArray(n, input.clone())
        assertEquals(n, result.size)
        val actualSums = IntArray(1 shl n) { mask ->
            var sum = 0
            for (i in result.indices) {
                if (mask and (1 shl i) != 0) {
                    sum += result[i]
                }
            }
            sum
        }
        assertArrayEquals(input.sortedArray(), actualSums.sortedArray())
    }
}
