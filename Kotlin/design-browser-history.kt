package designbrowserhistory

// Time:  ctor  : O(1)
//        visit : O(1)
//        back  : O(1)
//        foward: O(1)
// Space: O(n)
class BrowserHistory(homepage: String) {
    private val history = mutableListOf(homepage)
    private var curr = 0

    fun visit(url: String) {
        ++curr
        while (history.size > curr) {
            history.removeAt(history.lastIndex)
        }
        history.add(url)
    }

    fun back(steps: Int): String {
        curr = maxOf(curr - steps, 0)
        return history[curr]
    }

    fun forward(steps: Int): String {
        curr = minOf(curr + steps, history.size - 1)
        return history[curr]
    }
}
