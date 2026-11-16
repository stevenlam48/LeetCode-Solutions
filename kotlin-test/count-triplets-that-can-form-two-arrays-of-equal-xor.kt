package counttripletsthatcanformtwoarraysofequalxor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTripletsThatCanFormTwoArraysOfEqualXorTest {
    @Test
    fun firstExample() {
        assertEquals(4, Solution().countTriplets(intArrayOf(2, 3, 1, 6, 7)))
    }

    @Test
    fun secondExample() {
        assertEquals(10, Solution().countTriplets(intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun emptyAndSingleElementArrays() {
        assertEquals(0, Solution().countTriplets(intArrayOf()))
        assertEquals(0, Solution().countTriplets(intArrayOf(7)))
    }

    @Test
    fun allZerosAllowEverySplit() {
        assertEquals(10, Solution().countTriplets(intArrayOf(0, 0, 0, 0)))
    }
}
