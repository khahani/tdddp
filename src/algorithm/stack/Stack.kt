package algorithm.stack

interface Stack<T> {
    fun isEmpty(): Boolean
    fun push(item: T)
    fun pop(): String?
}
