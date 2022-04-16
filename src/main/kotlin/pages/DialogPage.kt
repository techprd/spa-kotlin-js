package pages

import com.techprd.material.components.Page
import com.techprd.material.components.button
import com.techprd.material.components.dialog
import com.techprd.material.components.layouts.Grid
import org.w3c.dom.HTMLElement
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.get

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
        val htmlDialog = simpleDialog.build()
        if (window["dialogPolyfill"] != null) {
            window["dialogPolyfill"].registerDialog(htmlDialog)
        }
        document.body!!.appendChild(htmlDialog)
        val grid = Grid(
            2,
            arrayListOf(
                button.build()
            )
        )
        return grid.build()
    }
}
