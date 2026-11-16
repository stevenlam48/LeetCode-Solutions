package sortarraybyparityii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SortArrayByParityIITest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(4, 5, 2, 7),
            Solution().sortArrayByParityII(intArrayOf(4, 2, 5, 7))
        )
    }

    @Test
    fun twoElements() {
        assertArrayEquals(intArrayOf(2, 3), Solution().sortArrayByParityII(intArrayOf(2, 3)))
    }

    @Test
    fun evenElementInWrongPlace() {
        assertArrayEquals(
            intArrayOf(2, 1, 4, 3),
            Solution().sortArrayByParityII(intArrayOf(3, 1, 4, 2))
        )
    }

    @Test
    fun largeCaseHasCorrectParityPositions() {
        val input = intArrayOf(6, 3, 8, 1, 4, 7, 2, 5)
        val result = Solution().sortArrayByParityII(input)
        for (i in result.indices) {
            assertEquals(i % 2, result[i] % 2)
        }
    }
}
