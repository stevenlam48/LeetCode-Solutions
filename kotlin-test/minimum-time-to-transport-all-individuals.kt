package minimumtimetotransportallindividuals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToTransportAllIndividualsTest {
    @Test
    fun oneIndividual() {
        assertEquals(5.0, Solution().minTime(1, 1, 2, intArrayOf(5), doubleArrayOf(1.0, 2.0)), 1e-9)
    }

    @Test
    fun crossTogether() {
        assertEquals(5.0, Solution().minTime(2, 2, 3, intArrayOf(2, 5), doubleArrayOf(1.0, 2.0, 1.0)), 1e-9)
    }

    @Test
    fun capacityOneCannotTransportTwoIndividuals() {
        assertEquals(-1.0, Solution().minTime(2, 1, 2, intArrayOf(2, 5), doubleArrayOf(1.0, 1.0)), 1e-9)
    }

    @Test
    fun fractionalMultiplier() {
        assertEquals(0.5, Solution().minTime(1, 1, 2, intArrayOf(1), doubleArrayOf(0.5, 1.0)), 1e-9)
    }
}
