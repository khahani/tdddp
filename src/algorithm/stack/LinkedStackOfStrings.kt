package algorithm.stack

class LinkedStackOfStrings : Stack<String> {

    private var first: Node? = null

    private class Node(val item: String, val next: Node?)

    override fun isEmpty(): Boolean = first == null

    override fun push(item: String) {
        val oldFirst = first
        first = Node(item, oldFirst)
    }

    override fun pop(): String {
        val item = first?.item
        first = first?.next
        return item!!
    }

    override fun toString(): String {

        if (isEmpty())
            return "[]"

        val sb = StringBuilder("[")

        var next: Node?
        do {
            sb.append(first?.item)
            next = first?.next
        } while (next != null)

        sb.append("]")

        return sb.toString()
    }
}