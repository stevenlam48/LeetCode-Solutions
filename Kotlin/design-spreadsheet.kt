package designspreadsheet

// Time:  ctor:      O(1)
//        setCell:   O(1)
//        resetCell: O(1)
//        getValue:  O(1)
// Space: O(n)

class Spreadsheet(rows: Int) {
    private val lookup = HashMap<String, Int>()

    fun setCell(cell: String, value: Int) {
        lookup[cell] = value
    }

    fun resetCell(cell: String) {
        lookup.remove(cell)
    }

    fun getValue(formula: String): Int {
        val i = formula.indexOf('+')
        val left = formula.substring(1, i)
        val right = formula.substring(i + 1)
        return value(left) + value(right)
    }

    private fun value(k: String): Int {
        return if (k[0].isLetter()) {
            lookup.getOrDefault(k, 0)
        } else {
            k.toInt()
        }
    }
}
