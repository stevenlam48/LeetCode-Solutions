package findallgoodindices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAllGoodIndicesTest {
    @Test
    fun example1() {
        assertEquals(listOf(2, 3), Solution().goodIndices(intArrayOf(2, 1, 1, 1, 3, 4, 1), 2))
    }

    @Test
    fun increasingArray() {
        assertEquals(listOf(1, 2, 3), Solution().goodIndices(intArrayOf(1, 2, 3, 4, 5), 1))
    }

    @Test
    fun decreasingArray() {
        assertEquals(emptyList<Int>(), Solution().goodIndices(intArrayOf(5, 4, 3, 2, 1), 2))
    }

    @Test
    fun noGoodIndex() {
        assertEquals(emptyList<Int>(), Solution().goodIndices(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun kEqualsOne() {
        assertEquals(listOf(1), Solution().goodIndices(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun allEqual() {
        assertEquals(listOf(2), Solution().goodIndices(intArrayOf(1, 1, 1, 1, 1), 2))
    }
}
