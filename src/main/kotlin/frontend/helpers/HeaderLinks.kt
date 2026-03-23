package frontend.helpers

enum class HeaderLinks(
    val expectedUrl: String,
    val linkName: String
) {
    PRODUCTS( "/products", "Products"),
    ORDERS( "/orders", "Orders"),
    CONTACT( "/contact", "Contact"),
}