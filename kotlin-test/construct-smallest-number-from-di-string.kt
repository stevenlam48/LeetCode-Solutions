package constructsmallestnumberfromdistring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructSmallestNumberFromDiStringTest {
    @Test
    fun testExample1() {
        assertEquals("123549876", Solution().smallestNumber("IIIDIDDD"))
    }

    @Test
    fun testExample2() {
        assertEquals("4321", Solution().smallestNumber("DDD"))
    }

    @Test
    fun testSingleI() {
        assertEquals("12", Solution().smallestNumber("I"))
    }

    @Test
    fun testSingleD() {
        assertEquals("21", Solution().smallestNumber("D"))
    }

    @Test
    fun testAllIncreasing() {
        assertEquals("12345", Solution().smallestNumber("IIII"))
    }
}
