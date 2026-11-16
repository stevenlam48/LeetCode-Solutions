package movingaveragefromdatastream

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MovingAverageFromDataStreamTest {
    @Test
    fun example() {
        val movingAverage = MovingAverage(3)
        assertEquals(1.0, movingAverage.next(1), 1e-5)
        assertEquals(5.5, movingAverage.next(10), 1e-5)
        assertEquals(14.0 / 3.0, movingAverage.next(3), 1e-5)
        assertEquals(6.0, movingAverage.next(5), 1e-5)
    }

    @Test
    fun windowOfOne() {
        val movingAverage = MovingAverage(1)
        assertEquals(4.0, movingAverage.next(4), 1e-5)
        assertEquals(-2.0, movingAverage.next(-2), 1e-5)
    }

    @Test
    fun windowLargerThanStream() {
        val movingAverage = MovingAverage(5)
        assertEquals(2.0, movingAverage.next(2), 1e-5)
        assertEquals(4.0, movingAverage.next(6), 1e-5)
    }

    @Test
    fun negativeValues() {
        val movingAverage = MovingAverage(2)
        assertEquals(-3.0, movingAverage.next(-3), 1e-5)
        assertEquals(-1.5, movingAverage.next(0), 1e-5)
        assertEquals(1.0, movingAverage.next(2), 1e-5)
    }
}
