package reorderlogfiles
// Time:  O(nlogn * l), n is the length of files, l is the average length of strings
// Space: O(l)

class Solution {
    fun reorderLogFiles(logs: List<String>): List<String> {
        val letterLogs = mutableListOf<String>()
        val digitLogs = mutableListOf<String>()
        for (log in logs) {
            if (log.last().isLetter()) {
                letterLogs.add(log)
            } else {
                digitLogs.add(log)
            }
        }
        val sortedLetters = letterLogs.sortedWith(Comparator { a, b ->
            val i = a.indexOf(' ')
            val j = b.indexOf(' ')
            val contentComparison = a.substring(i).compareTo(b.substring(j))
            if (contentComparison != 0) {
                contentComparison
            } else {
                a.substring(0, i).compareTo(b.substring(0, j))
            }
        })
        return sortedLetters + digitLogs
    }
}
