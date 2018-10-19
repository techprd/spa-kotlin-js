import com.techprd.material.Icons
import com.techprd.material.components.*
import org.w3c.dom.HTMLElement

class HomePage : Page() {

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
            type = ButtonType.RAISED
            label = "flat button"
            isColored = true
            hasRipple = true
        }

        val grid = Grid(2,
                arrayListOf(fabButton.build(), miniFabButton.build(), flatButton.build())
        )
        return grid.build()
    }
}
