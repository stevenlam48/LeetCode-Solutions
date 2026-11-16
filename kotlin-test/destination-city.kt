package destinationcity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DestinationCityTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        val paths = arrayOf(
            arrayOf("London", "New York"),
            arrayOf("New York", "Lima"),
            arrayOf("Lima", "Sao Paulo")
        )
        assertEquals("Sao Paulo", solution.destCity(paths))
    }

    @Test
    fun testSinglePath() {
        val paths = arrayOf(arrayOf("A", "B"))
        assertEquals("B", solution.destCity(paths))
    }

    @Test
    fun testTwoPaths() {
        val paths = arrayOf(
            arrayOf("B", "C"),
            arrayOf("A", "B")
        )
        assertEquals("C", solution.destCity(paths))
    }

    @Test
    fun testBranching() {
        val paths = arrayOf(
            arrayOf("A", "B"),
            arrayOf("A", "C"),
            arrayOf("C", "D"),
            arrayOf("B", "D")
        )
        assertEquals("D", solution.destCity(paths))
    }
}
