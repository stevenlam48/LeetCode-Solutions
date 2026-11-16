package removecomments

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveCommentsTest {
    @Test
    fun standardExample() {
        val source = listOf(
            "/*Test program */", "int main()", "{ ", "  // variable declaration ",
            "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ",
            "   testing */", "a = b + c;", "}"
        )
        assertEquals(
            listOf("int main()", "{ ", "  ", "int a, b, c;", "a = b + c;", "}"),
            Solution().removeComments(source)
        )
    }

    @Test
    fun blockCommentJoinsTwoLines() {
        val source = listOf("a/*comment", "text*/b", "c//comment")
        assertEquals(listOf("ab", "c"), Solution().removeComments(source))
    }

    @Test
    fun emptyLinesAndCommentOnlyLinesAreDropped() {
        val source = listOf("a//x", "////", "/*x*/", "b")
        assertEquals(listOf("a", "b"), Solution().removeComments(source))
    }

    @Test
    fun adjacentComments() {
        assertEquals(listOf("abc"), Solution().removeComments(listOf("a/**/b/*x*/c")))
    }
}
