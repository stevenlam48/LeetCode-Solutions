package minimumlightstoilluminatearoad

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumLightsToIlluminateARoadTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.minLights(intArrayOf(0, 0, 1, 0, 0)))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.minLights(intArrayOf(0, 0, 0, 0, 0)))
    }

    @Test
    fun testExample3() {
        assertEquals(0, solution.minLights(intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun testSingleUnlit() {
        assertEquals(1, solution.minLights(intArrayOf(0)))
    }

    @Test
    fun testSingleLit() {
        assertEquals(0, solution.minLights(intArrayOf(1)))
    }

    @Test
    fun testGapOfFour() {
        assertEquals(2, solution.minLights(intArrayOf(1, 0, 0, 0, 0, 0, 0, 1)))
    }
}
