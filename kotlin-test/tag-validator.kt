package tagvalidator

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TagValidatorTest {
    @Test
    fun validNestedTagsAndCData() {
        assertTrue(Solution().isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"))
        assertTrue(Solution().isValid("<DIV><A>text</A><B>more</B></DIV>"))
    }

    @Test
    fun invalidClosingTag() {
        assertFalse(Solution().isValid("<DIV>  unmatched < and </DIV>"))
        assertFalse(Solution().isValid("<DIV>closed with wrong tag</A>"))
    }

    @Test
    fun invalidTagNames() {
        assertFalse(Solution().isValid("<div>lowercase</div>"))
        assertFalse(Solution().isValid("<TOOLONGTAG>text</TOOLONGTAG>"))
    }

    @Test
    fun textOutsideTagIsRejected() {
        assertFalse(Solution().isValid("<A>valid</A>trailing"))
    }
}
