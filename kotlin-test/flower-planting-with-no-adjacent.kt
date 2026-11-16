package flowerplantingwithnoadjacent

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FlowerPlantingWithNoAdjacentTest {
    private val solution = Solution()

    @Test
    fun `three gardens in a cycle`() {
        val paths = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))

        assertArrayEquals(intArrayOf(1, 2, 3), solution.gardenNoAdj(3, paths))
    }

    @Test
    fun `two disconnected pairs`() {
        val paths = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))

        assertArrayEquals(intArrayOf(1, 2, 1, 2), solution.gardenNoAdj(4, paths))
    }

    @Test
    fun `four gardens with every garden connected`() {
        val paths = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 1),
            intArrayOf(1, 3),
            intArrayOf(2, 4)
        )

        assertArrayEquals(intArrayOf(1, 2, 3, 4), solution.gardenNoAdj(4, paths))
    }

    @Test
    fun `single garden without paths`() {
        assertArrayEquals(intArrayOf(1), solution.gardenNoAdj(1, emptyArray()))
    }
}
