package findxorbeautyofarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindXorBeautyOfArrayTest {
    @Test
    fun exampleOne() {
        assertEquals(5, Solution().xorBeauty(intArrayOf(1, 4)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(12, Solution().xorBeauty(intArrayOf(15, 45, 20, 2, 34, 35, 5, 20, 60, 20)))
    }

    @Test
    fun duplicatesCancel() {
        assertEquals(9, Solution().xorBeauty(intArrayOf(7, 7, 9)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().xorBeauty(intArrayOf()))
    }
}
