package designsql

// Time:  ctor:       O(t * max_m), t is the number of tables, max_m is the max number of columns in all tables
//        insertRow:  O(m), m is the number of columns
//        deleteRow:  O(1)
//        selectCell: O(m)
// Space: O(d), d is the total size of data

class SQL(names: List<String>, columns: IntArray) {
    private val table = HashMap<String, MutableList<MutableList<String>>>()

    init {
        for (i in names.indices) {
            table.getOrPut(names[i]) { ArrayList() }.add(MutableList(columns[i]) { "" })
        }
    }

    fun insertRow(name: String, row: List<String>) {
        val stored = ArrayList(row)
        stored.add("")  // soft delete
        table.getOrPut(name) { ArrayList() }.add(stored)
    }

    fun deleteRow(name: String, rowId: Int) {
        val row = table[name]!![rowId]
        row[row.size - 1] = "deleted"  // soft delete
    }

    fun selectCell(name: String, rowId: Int, columnId: Int): String {
        val row = table[name]!![rowId]
        return if (row[row.size - 1] != "deleted") row[columnId - 1] else ""
    }
}
