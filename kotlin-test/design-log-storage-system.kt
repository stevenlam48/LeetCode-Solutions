package designlogstoragesystem

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignLogStorageSystemTest {
    @Test
    fun leetCodeExample() {
        val logs = LogSystem()
        logs.put(1, "2017:01:01:23:59:59")
        logs.put(2, "2017:01:01:22:59:59")
        logs.put(3, "2016:01:01:00:00:00")
        assertEquals(listOf(3, 2, 1), logs.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"))
        assertEquals(listOf(2, 1), logs.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"))
    }

    @Test
    fun secondGranularityUsesInclusiveEndpoints() {
        val logs = LogSystem()
        logs.put(1, "2020:05:06:07:08:09")
        logs.put(2, "2020:05:06:07:08:10")
        logs.put(3, "2020:05:06:07:08:11")
        assertEquals(listOf(1, 2, 3), logs.retrieve("2020:05:06:07:08:09", "2020:05:06:07:08:11", "Second"))
    }

    @Test
    fun monthAndDayGranularity() {
        val logs = LogSystem()
        logs.put(1, "2020:04:30:23:59:59")
        logs.put(2, "2020:05:01:00:00:00")
        logs.put(3, "2020:05:31:23:59:59")
        logs.put(4, "2020:06:01:00:00:00")
        assertEquals(listOf(2, 3), logs.retrieve("2020:05:01:00:00:00", "2020:05:01:00:00:00", "Month"))
        assertEquals(listOf(1), logs.retrieve("2020:04:30:00:00:00", "2020:04:30:00:00:00", "Day"))
    }

    @Test
    fun duplicateTimestampsAndEmptyRange() {
        val logs = LogSystem()
        logs.put(2, "2020:01:01:00:00:00")
        logs.put(1, "2020:01:01:00:00:00")
        assertEquals(listOf(2, 1), logs.retrieve("2020:01:01:00:00:00", "2020:01:01:00:00:00", "Second"))
        assertEquals(emptyList<Int>(), logs.retrieve("2021:01:01:00:00:00", "2021:01:01:00:00:00", "Second"))
    }
}
