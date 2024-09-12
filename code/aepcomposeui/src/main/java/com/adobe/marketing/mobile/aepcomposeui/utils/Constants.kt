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
                    /* Define font-related constants here if needed */
                }
            }

            class Image {
                /* Define image-related constants here if needed */
            }

            class DismissButton {
                /* Define dismiss button-related constants here if needed */
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
                    const val CLR = "clr"
                    const val ALIGN = "align"
                    const val FONT = "font"
                }
            }

            class Button {
                companion object {
                    const val INTERACTION_ID = "interactId"
                    const val TEXT = "text"
                    const val ACTION_URL = "actionUrl"
                    const val BOR_WIDTH = "borWidth"
                    const val BOR_COLOR = "borColor"
                }
            }

            class Image {
                companion object {
                    const val URL = "url"
                    const val DARK_URL = "darkUrl"
                    const val BUNDLE = "bundle"
                    const val DARK_BUNDLE = "darkBundle"
                    const val ICON = "icon"
                    const val ICON_SIZE = "iconSize"
                }
            }
        }
    }
}
