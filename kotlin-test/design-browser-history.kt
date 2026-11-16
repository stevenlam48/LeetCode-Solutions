package designbrowserhistory

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignBrowserHistoryTest {
    @Test
    fun leetCodeExample() {
        val browser = BrowserHistory("leetcode.com")
        browser.visit("google.com")
        browser.visit("facebook.com")
        browser.visit("youtube.com")
        assertEquals("facebook.com", browser.back(1))
        assertEquals("google.com", browser.back(1))
        assertEquals("facebook.com", browser.forward(1))
        browser.visit("linkedin.com")
        assertEquals("linkedin.com", browser.forward(2))
        assertEquals("google.com", browser.back(2))
        assertEquals("leetcode.com", browser.back(7))
    }

    @Test
    fun movementIsClampedAtBothEnds() {
        val browser = BrowserHistory("home")
        assertEquals("home", browser.back(10))
        assertEquals("home", browser.forward(10))
        browser.visit("next")
        assertEquals("home", browser.back(5))
        assertEquals("next", browser.forward(5))
    }

    @Test
    fun visitAfterBackDiscardsForwardHistory() {
        val browser = BrowserHistory("a")
        browser.visit("b")
        browser.visit("c")
        assertEquals("a", browser.back(2))
        browser.visit("d")
        assertEquals("d", browser.forward(1))
        assertEquals("a", browser.back(1))
    }
}
