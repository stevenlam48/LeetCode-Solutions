package togglelightbulbs

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ToggleLightBulbsTest {
    @Test
    fun example() {
        assertArrayEquals(intArrayOf(2, 3), Solution().toggleLightBulbs(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun allToggledTwice() {
        assertArrayEquals(intArrayOf(), Solution().toggleLightBulbs(intArrayOf(2, 3, 2, 3)))
    }

    @Test
    fun oddCountStaysOn() {
        assertArrayEquals(intArrayOf(1), Solution().toggleLightBulbs(intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleBulb() {
        assertArrayEquals(intArrayOf(5), Solution().toggleLightBulbs(intArrayOf(5)))
    }
}
