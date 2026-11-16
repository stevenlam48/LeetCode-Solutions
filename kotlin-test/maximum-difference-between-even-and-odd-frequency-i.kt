package maximumdifferencebetweenevenandoddfrequencyi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDifferenceBetweenEvenAndOddFrequencyITest {
    @Test
    fun firstExample() {
        assertEquals(3, Solution().maxDifference("aaaaabbc"))
    }

    @Test
    fun secondExample() {
        assertEquals(1, Solution().maxDifference("abcabcab"))
    }

    @Test
    fun negativeDifference() {
        assertEquals(-1, Solution().maxDifference("mmsu"))
    }
}
