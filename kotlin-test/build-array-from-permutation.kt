package buildarrayfrompermutation

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BuildArrayFromPermutationTest {
    @Test
    fun leetCodeExample() {
        assertArrayEquals(intArrayOf(0, 1, 2, 4, 5, 3), Solution().buildArray(intArrayOf(0, 2, 1, 5, 3, 4)))
    }

    @Test
    fun threeElementCycle() {
        assertArrayEquals(intArrayOf(2, 0, 1), Solution().buildArray(intArrayOf(1, 2, 0)))
    }

    @Test
    fun mixedCycleStructure() {
        assertArrayEquals(intArrayOf(3, 4, 2, 0, 1), Solution().buildArray(intArrayOf(4, 0, 2, 1, 3)))
    }

    @Test
    fun emptyAndSingleElement() {
        assertArrayEquals(intArrayOf(), Solution().buildArray(intArrayOf()))
        assertArrayEquals(intArrayOf(0), Solution().buildArray(intArrayOf(0)))
    }
}
