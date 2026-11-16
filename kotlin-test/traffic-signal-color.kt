package trafficsignalcolor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrafficSignalColorTest {
    @Test
    fun greenAtZero() {
        assertEquals("Green", Solution().trafficSignal(0))
    }

    @Test
    fun orangeAtThirty() {
        assertEquals("Orange", Solution().trafficSignal(30))
    }

    @Test
    fun redAfterOrange() {
        assertEquals("Red", Solution().trafficSignal(31))
    }

    @Test
    fun redAtNinety() {
        assertEquals("Red", Solution().trafficSignal(90))
    }

    @Test
    fun invalidAfterNinety() {
        assertEquals("Invalid", Solution().trafficSignal(91))
    }

    @Test
    fun invalidBeforeOrange() {
        assertEquals("Invalid", Solution().trafficSignal(29))
    }
}
