package minimumrotationstodialanumberii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRotationsToDialANumberIITest {
    @Test
    fun allZeros() {
        assertEquals(0, Solution().minRotations(4, "0000"))
    }

    @Test
    fun increasingDigits() {
        assertEquals(4, Solution().minRotations(4, "1234"))
    }

    @Test
    fun exampleWithSaving() {
        assertEquals(4, Solution().minRotations(2, "29"))
    }

    @Test
    fun wrapAround() {
        assertEquals(1, Solution().minRotations(2, "90"))
    }

    @Test
    fun noSaving() {
        assertEquals(5, Solution().minRotations(4, "2345"))
    }
}
