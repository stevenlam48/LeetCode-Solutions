package sumofbeautyinthearray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfBeautyInTheArrayTest {
    @Test
    fun exampleOne() {
        assertEquals(2, Solution().sumOfBeauties(intArrayOf(1, 2, 3)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(1, Solution().sumOfBeauties(intArrayOf(2, 4, 6, 4)))
    }

    @Test
    fun exampleThree() {
        assertEquals(0, Solution().sumOfBeauties(intArrayOf(3, 2, 1)))
    }

    @Test
    fun threeElementsWithoutBeauty() {
        assertEquals(0, Solution().sumOfBeauties(intArrayOf(2, 4, 3)))
        assertEquals(0, Solution().sumOfBeauties(intArrayOf(1, 1, 1)))
    }
}
