package htmlentityparser

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HtmlEntityParserTest {
    @Test
    fun example1() {
        assertEquals(
            "& is an HTML entity but &ambassador; is not.",
            Solution().entityParser("&amp; is an HTML entity but &ambassador; is not.")
        )
    }

    @Test
    fun example2() {
        assertEquals(
            "and I quote: \"...\"",
            Solution().entityParser("and I quote: &quot;...&quot;")
        )
    }

    @Test
    fun example3() {
        assertEquals(
            "Stay home! Practice on Leetcode :)",
            Solution().entityParser("Stay home! Practice on Leetcode :)")
        )
    }

    @Test
    fun example4() {
        assertEquals(
            "x > y && x < y is always false",
            Solution().entityParser("x &gt; y &amp;&amp; x &lt; y is always false")
        )
    }

    @Test
    fun example5() {
        assertEquals(
            "leetcode.com/problemset/all",
            Solution().entityParser("leetcode.com&frasl;problemset&frasl;all")
        )
    }

    @Test
    fun edgeCases() {
        assertEquals("", Solution().entityParser(""))
        assertEquals("&amp", Solution().entityParser("&amp"))
        assertEquals("'", Solution().entityParser("&apos;"))
        assertEquals("&", Solution().entityParser("&amp;"))
    }
}
