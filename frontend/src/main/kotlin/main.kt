import kotlinx.html.dom.append
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    launch {
        val response = window.fetch("http://192.168.1.82:8080/todo/").await()
        val todos = mapJson(response.json().await(), ::deserializeTodo)

        document.body!!.append {
            Todos(todos)
        }
    }
}