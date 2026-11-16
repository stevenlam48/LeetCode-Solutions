package minimumrotationstodialanumberi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRotationsToDialANumberITest {
    @Test
    fun example1() {
        assertEquals(5, Solution().minRotations("2345"))
    }

    @Test
    fun allZeros() {
        assertEquals(0, Solution().minRotations("0000"))
    }

    @Test
    fun increasingDigits() {
        assertEquals(4, Solution().minRotations("1234"))
    }

    @Test
    fun singleDigit() {
        assertEquals(1, Solution().minRotations("9"))
        assertEquals(0, Solution().minRotations("0"))
    }

    @Test
    fun wrapAround() {
        assertEquals(2, Solution().minRotations("090"))
        assertEquals(2, Solution().minRotations("10"))
    }
}
