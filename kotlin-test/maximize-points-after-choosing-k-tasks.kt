package maximizepointsafterchoosingktasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizePointsAfterChoosingKTasksTest {
    @Test
    fun choosesTwoLargestTechniqueAdvantages() {
        assertEquals(
            22L,
            Solution().maxPoints(intArrayOf(5, 2, 10), intArrayOf(10, 3, 5), 2)
        )
    }

    @Test
    fun equalAdvantagesGiveSameResult() {
        assertEquals(
            12L,
            Solution().maxPoints(intArrayOf(3, 4, 2), intArrayOf(1, 2, 5), 1)
        )
    }

    @Test
    fun allTasksUseFirstTechnique() {
        assertEquals(
            17L,
            Solution().maxPoints(intArrayOf(5, 2, 10), intArrayOf(10, 3, 5), 3)
        )
    }

    @Test
    fun totalUsesLongAccumulator() {
        assertEquals(
            3_000_000_000L,
            Solution().maxPoints(
                intArrayOf(1_000_000_000, 1_000_000_000, 1_000_000_000),
                intArrayOf(0, 0, 0),
                1
            )
        )
    }
}
