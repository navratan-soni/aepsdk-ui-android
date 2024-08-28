import androidx.compose.material.MaterialTheme
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

class Constants {
    companion object {
        const val LOG_TAG = "AEPComposeUi"
        const val EXTENSION_VERSION = "1.0.1"
    }

    class CardTemplate {
        companion object {
            const val SmallImage = "SmallImage"
            const val LargeImage = "LargeImage"
            const val ImageOnly = "ImageOnly"
        }

        class DefaultStyle {
            companion object {
                const val PADDING = 8.0
            }

            class Text {
                companion object {
                   /* val TITLE_FONT = FontFamily.Serif
                    val BODY_FONT = FontFamily.Serif
                    val BUTTON_FONT = FontFamily.Serif

                    val TITLE_COLOR = MaterialTheme.colors.primary

                    val BODY_COLOR = Color.Secondary

                    val BUTTON_COLOR = Color.Blue*/
                }
            }

            class Image {
                /*companion object {
                    val ICON_COLOR = Color.Primary
                    const val ICON_SIZE = 13
                }*/
            }

            class DismissButton {
                /*companion object {
                    val ALIGNMENT = Alignment.TopTrailing
                    const val SIZE = 13
                }*/
            }
        }

        class InteractionID {
            companion object {
                const val cardTapped = "Card Clicked"
            }
        }

        class SchemaData {
            companion object {
                const val TITLE = "title"
                const val BODY = "body"
                const val IMAGE = "image"
                const val ACTION_URL = "actionUrl"
                const val BUTTONS = "buttons"
                const val DISMISS_BTN = "dismissBtn"
            }

            class Meta {
                companion object {
                    const val ADOBE_DATA = "adobe"
                    const val TEMPLATE = "template"
                }
            }
        }

        class DismissButton {
            companion object {
                const val STYLE = "style"
            }

            class Icon {
                companion object {
                    const val SIMPLE = "xmark"
                    const val CIRCLE = "xmark.circle.fill"
                }
            }
        }

        class UIElement {
            class Text {
                companion object {
                    const val CONTENT = "content"
                }
            }

            class Button {
                companion object {
                    const val INTERACTION_ID = "interactId"
                    const val TEXT = "text"
                    const val ACTION_URL = "actionUrl"
                }
            }

            class Image {
                companion object {
                    const val URL = "url"
                    const val DARK_URL = "darkUrl"
                    const val BUNDLE = "bundle"
                    const val DARK_BUNDLE = "darkBundle"
                    const val ICON = "icon"
                }
            }
        }
    }
}
