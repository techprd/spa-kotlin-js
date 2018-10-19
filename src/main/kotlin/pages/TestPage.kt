import com.techprd.material.components.Grid
import com.techprd.material.components.Page
import kotlinx.html.button
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.js.onClickFunction
import kotlinx.html.p
import org.w3c.dom.HTMLElement
import kotlin.browser.document
import kotlin.browser.window

class TestPage : Page() {
    override fun build(): HTMLElement {
        val grid = Grid(4, arrayListOf(
                document.create.div {
                    p {
                        +data.get(0).toString()
                    }
                    button {
                        classes = setOf("mdl-button", "mdl-js-button",
                                "mdl-button--raised", "mdl-js-ripple-effect")
                        +"go to home"
                        onClickFunction = {
                            window.location.hash = "/home/"
                        }
                    }
                }
        ))
        return grid.build()
    }
}