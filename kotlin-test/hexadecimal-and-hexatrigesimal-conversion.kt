package hexadecimalandhexatrigesimalconversion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HexadecimalAndHexatrigesimalConversionTest {
    @Test
    fun one() {
        assertEquals("11", Solution().concatHex36(1))
    }

    @Test
    fun standardExample() {
        assertEquals("A91P1", Solution().concatHex36(13))
    }

    @Test
    fun base36CubeUsesMultipleLetters() {
        assertEquals("64RS", Solution().concatHex36(10))
    }

    @Test
    fun cubeIsPowerOfBase36() {
        assertEquals("5101000", Solution().concatHex36(36))
    }

    @Test
    fun maximumConstraintValue() {
        assertEquals("F4240GJDGXS", Solution().concatHex36(1000))
    }
}
