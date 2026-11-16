package totalcharactersinstringaftertransformationsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalCharactersInStringAfterTransformationsITest {
    @Test
    fun exampleAbcyy() {
        assertEquals(7, Solution().lengthAfterTransformations("abcyy", 2))
    }

    @Test
    fun exampleAzbk() {
        assertEquals(5, Solution().lengthAfterTransformations("azbk", 1))
    }

    @Test
    fun noTransformations() {
        assertEquals(3, Solution().lengthAfterTransformations("abc", 0))
    }

    @Test
    fun singleZ() {
        assertEquals(2, Solution().lengthAfterTransformations("z", 1))
    }
}
