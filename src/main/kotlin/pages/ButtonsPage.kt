package pages

import com.techprd.material.Icons
import com.techprd.material.components.ButtonType
import com.techprd.material.components.Page
import com.techprd.material.components.button
import com.techprd.material.components.layouts.Grid
import org.w3c.dom.HTMLElement

class ButtonsPage : Page() {
    override fun build(): HTMLElement {

        val fabButton = button {
            type = ButtonType.FAB
            icon = Icons.add
            isColored = true
            hasRipple = true
        }

        val miniFabButton = button {
            type = ButtonType.MINI_FAB
            icon = Icons.person
            isColored = true
            hasRipple = true
        }

        val flatButton = button {
            type = ButtonType.FLAT
            label = "Flat Button"
            isColored = true
            hasRipple = true
        }

        val raisedButton = button {
            type = ButtonType.RAISED
            label = "Raised Button"
            isColored = true
            hasRipple = true
        }

        val grid = Grid(
            2,
            arrayListOf(fabButton.build(), miniFabButton.build(), flatButton.build(), raisedButton.build())
        )
        return grid.build()
    }

}
