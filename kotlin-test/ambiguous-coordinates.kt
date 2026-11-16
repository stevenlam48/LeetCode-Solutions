package ambiguouscoordinates

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AmbiguousCoordinatesTest {
    @Test
    fun testExample1() {
        assertEquals(
            listOf("(1, 2.3)", "(1, 23)", "(1.2, 3)", "(12, 3)"),
            Solution().ambiguousCoordinates("(123)")
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            listOf("(0, 1.23)", "(0, 12.3)", "(0, 123)", "(0.1, 2.3)", "(0.1, 23)", "(0.12, 3)"),
            Solution().ambiguousCoordinates("(0123)")
        )
    }

    @Test
    fun testExample3() {
        assertEquals(
            listOf("(0, 0.011)", "(0.001, 1)"),
            Solution().ambiguousCoordinates("(00011)")
        )
    }

    @Test
    fun testTrailingZeros() {
        assertEquals(listOf("(10, 0)"), Solution().ambiguousCoordinates("(100)"))
        assertEquals(listOf("(0, 0.1)"), Solution().ambiguousCoordinates("(001)"))
    }
}
