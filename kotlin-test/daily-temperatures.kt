package dailytemperatures

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DailyTemperaturesTest {
    @Test
    fun example1() {
        val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        assertArrayEquals(
            intArrayOf(1, 1, 4, 2, 1, 1, 0, 0),
            Solution().dailyTemperatures(temperatures)
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(1, 1, 1, 0),
            Solution().dailyTemperatures(intArrayOf(30, 40, 50, 60))
        )
    }

    @Test
    fun example3() {
        assertArrayEquals(
            intArrayOf(1, 1, 0),
            Solution().dailyTemperatures(intArrayOf(30, 60, 90))
        )
    }

    @Test
    fun decreasing() {
        assertArrayEquals(
            intArrayOf(0, 0, 0),
            Solution().dailyTemperatures(intArrayOf(90, 80, 70))
        )
    }

    @Test
    fun singleDay() {
        assertArrayEquals(intArrayOf(0), Solution().dailyTemperatures(intArrayOf(50)))
    }

    @Test
    fun equalTemperatures() {
        assertArrayEquals(
            intArrayOf(0, 0, 0),
            Solution().dailyTemperatures(intArrayOf(70, 70, 70))
        )
    }
}
