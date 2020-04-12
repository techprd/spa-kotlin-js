package pages

import com.techprd.material.components.Page
import com.techprd.material.components.chip
import com.techprd.material.components.layouts.Grid
import org.w3c.dom.HTMLElement

class ChipsPage : Page() {
    override fun build(): HTMLElement {
        val simpleChip = chip {
            label = "Simple Chip"
            isButton = false
            deletable = true
        }
        val buttonChip = chip {
            label = "Button Chip"
            isButton = true
            deletable = true
        }
        val contactChipSimple = chip {
            label = "Button Chip"
            isButton = false
            deletable = false
            isContactChip = true
            contactChipChars = "AS"
        }
        val contactChipImage = chip {
            label = "Button Chip"
            isButton = false
            deletable = true
            isContactChip = true
            contactChipImageSrc = "https://getmdl.io/templates/dashboard/images/user.jpg"
        }
        val grid = Grid(
            2,
            arrayListOf(
                simpleChip.build(),
                buttonChip.build(),
                contactChipSimple.build(),
                contactChipImage.build()
            )
        )
        return grid.build()
    }
}
