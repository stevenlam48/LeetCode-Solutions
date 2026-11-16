package convertthetemperature

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertTheTemperatureTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val result = solution.convertTemperature(36.50)
        assertEquals(309.65, result[0], 1e-9)
        assertEquals(97.70, result[1], 1e-9)
    }

    @Test
    fun testExampleTwo() {
        val result = solution.convertTemperature(122.11)
        assertEquals(395.26, result[0], 1e-9)
        assertEquals(251.798, result[1], 1e-9)
    }

    @Test
    fun testZero() {
        val result = solution.convertTemperature(0.0)
        assertEquals(273.15, result[0], 1e-9)
        assertEquals(32.0, result[1], 1e-9)
    }
}
