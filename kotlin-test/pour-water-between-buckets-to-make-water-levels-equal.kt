package pourwaterbetweenbucketstomakewaterlevelsequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PourWaterBetweenBucketsToMakeWaterLevelsEqualTest {
    @Test
    fun standardLossCase() {
        assertEquals(2.6, Solution().equalizeWater(intArrayOf(1, 2, 7), 50), 1e-5)
    }

    @Test
    fun noLoss() {
        assertEquals(10.0 / 3.0, Solution().equalizeWater(intArrayOf(1, 2, 7), 0), 1e-5)
    }

    @Test
    fun alreadyEqual() {
        assertEquals(4.0, Solution().equalizeWater(intArrayOf(4, 4, 4), 50), 1e-5)
    }

    @Test
    fun fractionalRetention() {
        assertEquals(100.0 / 7.0, Solution().equalizeWater(intArrayOf(10, 20), 25), 1e-5)
    }
}
