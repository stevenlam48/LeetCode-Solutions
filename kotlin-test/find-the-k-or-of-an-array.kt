package findthekorofanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKOrOfAnArrayTest {
    @Test
    fun example1() {
        assertEquals(9, Solution().findKOr(intArrayOf(7, 12, 9, 8, 9, 15), 4))
    }

    @Test
    fun repeatedValue() {
        assertEquals(2, Solution().findKOr(intArrayOf(2, 2, 2), 2))
    }

    @Test
    fun kEqualsOne() {
        assertEquals(3, Solution().findKOr(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun allZeros() {
        assertEquals(0, Solution().findKOr(intArrayOf(0), 1))
    }
}
