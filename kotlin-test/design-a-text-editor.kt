package designatexteditor

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignATextEditorTest {
    @Test
    fun testExample() {
        val editor = TextEditor()
        editor.addText("leetcode")
        assertEquals(4, editor.deleteText(4))
        editor.addText("practice")
        assertEquals("etpractice", editor.cursorRight(3))
        assertEquals("leet", editor.cursorLeft(8))
        assertEquals(4, editor.deleteText(10))
        assertEquals("", editor.cursorLeft(2))
        assertEquals("practi", editor.cursorRight(6))
    }

    @Test
    fun testDeleteMoreThanAvailable() {
        val editor = TextEditor()
        editor.addText("abc")
        assertEquals(3, editor.deleteText(10))
        assertEquals(0, editor.deleteText(1))
    }

    @Test
    fun testCursorLeftBeyondStart() {
        val editor = TextEditor()
        editor.addText("hello")
        assertEquals("", editor.cursorLeft(100))
        assertEquals("", editor.cursorLeft(1))
    }

    @Test
    fun testCursorRightBeyondEnd() {
        val editor = TextEditor()
        editor.addText("abc")
        assertEquals("abc", editor.cursorRight(100))
    }

    @Test
    fun testAddTextAtCursor() {
        val editor = TextEditor()
        editor.addText("world")
        editor.cursorLeft(5)
        editor.addText("hello ")
        assertEquals("ello world", editor.cursorRight(100))
    }
}
