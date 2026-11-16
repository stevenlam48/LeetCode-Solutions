package countvowelspermutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountVowelsPermutationTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().countVowelPermutation(1))
    }

    @Test
    fun example2() {
        assertEquals(10, Solution().countVowelPermutation(2))
    }

    @Test
    fun example3() {
        assertEquals(68, Solution().countVowelPermutation(5))
    }

    @Test
    fun threeLength() {
        assertEquals(19, Solution().countVowelPermutation(3))
    }

    @Test
    fun fourLength() {
        assertEquals(35, Solution().countVowelPermutation(4))
    }
}
