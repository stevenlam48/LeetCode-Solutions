package verifypreorderserializationofabinarytree

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class VerifyPreorderSerializationOfABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun acceptsValidSerialization() {
        assertTrue(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"))
    }

    @Test
    fun rejectsIncompleteOrExtraNodes() {
        assertFalse(solution.isValidSerialization("1,#"))
        assertFalse(solution.isValidSerialization("9,#,#,1"))
        assertFalse(solution.isValidSerialization("1"))
    }

    @Test
    fun handlesOnlyNullAndEmptyInput() {
        assertTrue(solution.isValidSerialization("#"))
        assertFalse(solution.isValidSerialization(""))
    }
}
