package minimumchangestomakealternatingbinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumChangesToMakeAlternatingBinaryStringTest {
    @Test
    fun standardExample() = assertEquals(1, Solution().minOperations("0100"))

    @Test
    fun alreadyAlternating() = assertEquals(0, Solution().minOperations("10"))

    @Test
    fun equalRuns() = assertEquals(2, Solution().minOperations("111000"))

    @Test
    fun singleCharacter() = assertEquals(0, Solution().minOperations("0"))
}
