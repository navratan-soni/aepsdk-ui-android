import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adobe.marketing.mobile.aepcomposeui.uicomposables.AEPTextComposable
import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPFont
import com.adobe.marketing.mobile.aepcomposeui.uimodel.AEPText

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF,
    device = "spec:width=1080px,height=2340px,dpi=440"
)
@Composable
fun AEPTextComposableTestPreviews() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Basic usage
        AEPTextComposable(content = "Basic Text")

        // Color variations
        AEPTextComposable(content = "Red Text", clr = "#FF0000")
        AEPTextComposable(content = "Green Text", clr = "#00FF00")
        AEPTextComposable(content = "Blue Text", clr = "#0000FF")
        AEPTextComposable(content = "Invalid Color", clr = "invalid") // Test invalid color

        // Alignment variations
        AEPTextComposable(content = "Left Aligned", align = "left")
        AEPTextComposable(content = "Center Aligned", align = "center")
        AEPTextComposable(content = "Right Aligned", align = "right")
        AEPTextComposable(
            content = "Invalid Alignment",
            align = "invalid"
        ) // Test invalid alignment

        // Font variations
        AEPTextComposable(content = "Large Text", font = AEPFont(size = 24))
        AEPTextComposable(content = "Small Text", font = AEPFont(size = 10))
        AEPTextComposable(content = "Bold Text", font = AEPFont(weight = "bold"))
        AEPTextComposable(content = "Italic Text", font = AEPFont(style = listOf("italic")))
        AEPTextComposable(content = "Bold Italic Text", font = AEPFont(weight = "bold", style =  listOf("italic")))

        // Combination of properties
        AEPTextComposable(
            content = "Complex Styling",
            clr = "#800080",
            align = "center",
            font = AEPFont(size = 18, weight = "bold", style = listOf("italic"))
        )

        // Edge cases
        AEPTextComposable(content = "") // Empty string
        AEPTextComposable(content = "Very Long Text ".repeat(20)) // Very long text
        AEPTextComposable(content = "Special Characters: !@#$%^&*()_+{}[]|\\:;\"'<>,.?/")
        AEPTextComposable(content = "Multi\nLine\nText") // Multi-line text

        // Null values for optional parameters
        AEPTextComposable(content = "Null Color", clr = null)
        AEPTextComposable(content = "Null Alignment", align = null)
        AEPTextComposable(content = "Null Font", font = null)

        // Extreme font sizes
        AEPTextComposable(content = "Tiny Text", font = AEPFont(size = 1))
        AEPTextComposable(content = "Huge Text", font = AEPFont(size = 100))
    }
}