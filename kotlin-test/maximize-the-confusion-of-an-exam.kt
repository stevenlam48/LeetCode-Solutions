package maximizetheconfusionofanexam

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheConfusionOfAnExamTest {
    @Test
    fun exampleOne() {
        assertEquals(4, Solution().maxConsecutiveAnswers("TTFF", 2))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, Solution().maxConsecutiveAnswers("TFFT", 1))
    }

    @Test
    fun exampleThree() {
        assertEquals(5, Solution().maxConsecutiveAnswers("TTFTTFTT", 1))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().maxConsecutiveAnswers("T", 0))
    }

    @Test
    fun allSame() {
        assertEquals(4, Solution().maxConsecutiveAnswers("TTTT", 2))
    }
}
