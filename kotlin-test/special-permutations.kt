package specialpermutations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpecialPermutationsTest {
    @Test
    fun exampleOne() {
        assertEquals(2, Solution().specialPerm(intArrayOf(2, 3, 6)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2, Solution().specialPerm(intArrayOf(1, 4, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().specialPerm(intArrayOf(1)))
    }

    @Test
    fun allOnes() {
        assertEquals(6, Solution().specialPerm(intArrayOf(1, 1, 1)))
    }
}
