package totalcharactersinstringaftertransformationsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalCharactersInStringAfterTransformationsIITest {
    @Test
    fun exampleUnitNums() {
        assertEquals(5, Solution().lengthAfterTransformations("abcyy", 2, IntArray(26) { 1 }))
    }

    @Test
    fun exampleNumsTwo() {
        assertEquals(8, Solution().lengthAfterTransformations("azbk", 1, IntArray(26) { 2 }))
    }

    @Test
    fun noTransformations() {
        assertEquals(3, Solution().lengthAfterTransformations("abc", 0, IntArray(26) { 1 }))
    }

    @Test
    fun singleZ() {
        assertEquals(1, Solution().lengthAfterTransformations("z", 1, IntArray(26) { 1 }))
    }
}
