package faultysensor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FaultySensorTest {
    @Test
    fun identifiesFirstSensorAsFaulty() {
        assertEquals(1, Solution().badSensor(intArrayOf(2, 3, 4, 5), intArrayOf(2, 1, 3, 4)))
    }

    @Test
    fun identifiesSecondSensorAsFaulty() {
        assertEquals(2, Solution().badSensor(intArrayOf(2, 3, 2, 2, 3, 2), intArrayOf(2, 3, 2, 3, 2, 7)))
    }

    @Test
    fun cannotIdentifyFaultAtLastReading() {
        assertEquals(-1, Solution().badSensor(intArrayOf(2, 2, 2, 2, 2), intArrayOf(2, 2, 2, 2, 5)))
    }

    @Test
    fun identicalReadingsHaveNoFault() {
        assertEquals(-1, Solution().badSensor(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun handlesEmptyAndSingleReadings() {
        assertEquals(-1, Solution().badSensor(intArrayOf(), intArrayOf()))
        assertEquals(-1, Solution().badSensor(intArrayOf(1), intArrayOf(2)))
    }
}
