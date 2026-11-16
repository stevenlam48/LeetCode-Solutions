package confusingnumberii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConfusingNumberIITest {
    @Test
    fun handlesZeroAndSmallUpperBounds() {
        assertEquals(0, Solution().confusingNumberII(0))
        assertEquals(2, Solution().confusingNumberII(9))
        assertEquals(3, Solution().confusingNumberII(10))
    }

    @Test
    fun matchesLeetCodeExamples() {
        assertEquals(6, Solution().confusingNumberII(20))
        assertEquals(19, Solution().confusingNumberII(100))
    }

    @Test
    fun matchesDirectCountThroughOneThousand() {
        var expected = 0
        for (n in 1..1000) {
            if (isConfusing(n)) ++expected
            assertEquals(expected, Solution().confusingNumberII(n))
        }
    }
}

private fun isConfusing(n: Int): Boolean {
    val rotations = mapOf('0' to '0', '1' to '1', '6' to '9', '8' to '8', '9' to '6')
    val original = n.toString()
    var rotated = ""
    for (c in original) {
        if (c !in rotations) return false
        rotated = rotations.getValue(c) + rotated
    }
    return rotated.toInt() != n
}
