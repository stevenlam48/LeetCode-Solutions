package earliestfinishtimeforlandandwaterridesi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EarliestFinishTimeForLandAndWaterRidesITest {
    @Test
    fun example1() {
        assertEquals(
            9,
            Solution().earliestFinishTime(
                intArrayOf(2, 8), intArrayOf(4, 1),
                intArrayOf(6), intArrayOf(3)
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            14,
            Solution().earliestFinishTime(
                intArrayOf(5), intArrayOf(3),
                intArrayOf(1), intArrayOf(10)
            )
        )
    }

    @Test
    fun overlappingStarts() {
        assertEquals(
            4,
            Solution().earliestFinishTime(
                intArrayOf(1, 2), intArrayOf(1, 1),
                intArrayOf(3, 4), intArrayOf(1, 1)
            )
        )
    }

    @Test
    fun singleOptionEach() {
        assertEquals(
            7,
            Solution().earliestFinishTime(
                intArrayOf(1), intArrayOf(2),
                intArrayOf(3), intArrayOf(4)
            )
        )
    }
}
