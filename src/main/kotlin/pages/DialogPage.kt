package pages

import com.techprd.material.components.Page
import com.techprd.material.components.button
import com.techprd.material.components.dialog
import com.techprd.material.components.layouts.Grid
import org.w3c.dom.HTMLElement
import kotlin.browser.document

class DialogPage : Page() {
    override fun build(): HTMLElement {
        val simpleDialog = dialog {
            titleText = "Simple Dialog"
        }
        val button = button {
            label = "Show dialog"
            onClickFun = {
                simpleDialog.showDialog()
            }
        }
        document.body!!.appendChild(simpleDialog.build())
        val grid = Grid(
            2,
            arrayListOf(
                button.build()
            )
        )
        return grid.build()
    }
}
