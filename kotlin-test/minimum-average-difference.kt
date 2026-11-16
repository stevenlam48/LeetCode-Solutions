package minimumaveragedifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAverageDifferenceTest {
    @Test
    fun standardExample() = assertEquals(3, Solution().minimumAverageDifference(intArrayOf(2, 5, 3, 9, 5, 3)))

    @Test
    fun singleElement() = assertEquals(0, Solution().minimumAverageDifference(intArrayOf(0)))

    @Test
    fun tieKeepsFirstIndex() = assertEquals(2, Solution().minimumAverageDifference(intArrayOf(4, 2, 0)))

    @Test
    fun equalValues() = assertEquals(0, Solution().minimumAverageDifference(intArrayOf(2, 2, 2, 2)))
}
