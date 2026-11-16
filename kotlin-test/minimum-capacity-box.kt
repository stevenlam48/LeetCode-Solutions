package minimumcapacitybox

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCapacityBoxTest {
    @Test
    fun smallestSufficientBox() = assertEquals(2, Solution().minimumIndex(intArrayOf(1, 5, 3, 4), 3))

    @Test
    fun equalCapacitiesChooseFirst() = assertEquals(1, Solution().minimumIndex(intArrayOf(1, 5, 5, 4), 5))

    @Test
    fun noSufficientBox() = assertEquals(-1, Solution().minimumIndex(intArrayOf(1, 2, 3), 4))

    @Test
    fun exactCapacityAtFirstBox() = assertEquals(0, Solution().minimumIndex(intArrayOf(4, 6, 5), 4))
}
