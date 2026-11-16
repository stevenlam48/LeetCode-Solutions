package checkifnumbersareascendinginasentence

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfNumbersAreAscendingInASentenceTest {
    private val solution = Solution()

    @Test
    fun strictlyIncreasingNumbers() {
        assertTrue(solution.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"))
    }

    @Test
    fun equalNumbersAreNotAscending() {
        assertFalse(solution.areNumbersAscending("hello world 5 x 5"))
    }

    @Test
    fun decreasingNumbers() {
        assertFalse(solution.areNumbersAscending("10 dogs 2 cats"))
    }

    @Test
    fun numbersBetweenOtherCharacters() {
        assertTrue(solution.areNumbersAscending("a 1 b 2 c 3"))
    }

    @Test
    fun noNumbers() {
        assertTrue(solution.areNumbersAscending("no numbers"))
    }
}
