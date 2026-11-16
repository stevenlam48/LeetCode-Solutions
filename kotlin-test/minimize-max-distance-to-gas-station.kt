package minimizemaxdistancetogasstation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeMaxDistanceToGasStationTest {
    @Test
    fun evenlySpacedStations() {
        val stations = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(0.5, Solution().minmaxGasDist(stations, 9), 1e-5)
    }

    @Test
    fun unevenlySpacedStations() {
        val stations = intArrayOf(23, 24, 36, 39, 46, 56, 57, 65, 84, 98)
        assertEquals(14.0, Solution().minmaxGasDist(stations, 1), 1e-5)
    }

    @Test
    fun noAdditionalStations() {
        val stations = intArrayOf(1, 4, 10)
        assertEquals(6.0, Solution().minmaxGasDist(stations, 0), 1e-5)
    }

    @Test
    fun twoAdditionalStationsInOneGap() {
        val stations = intArrayOf(1, 10)
        assertEquals(3.0, Solution().minmaxGasDist(stations, 2), 1e-5)
    }
}
