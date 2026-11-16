package countgoodtripletsinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodTripletsInAnArrayTest {
    private val solution = Solution()

    @Test
    fun countsFirstExample() {
        assertEquals(
            1L,
            solution.goodTriplets(intArrayOf(0, 1, 2, 3, 4), intArrayOf(1, 3, 0, 4, 2))
        )
    }

    @Test
    fun countsSecondExample() {
        assertEquals(1L, solution.goodTriplets(intArrayOf(2, 0, 1, 3), intArrayOf(0, 1, 2, 3)))
    }

    @Test
    fun reverseOrderHasNoCommonIncreasingTriplet() {
        assertEquals(0L, solution.goodTriplets(intArrayOf(0, 1, 2, 3), intArrayOf(3, 2, 1, 0)))
    }
}
