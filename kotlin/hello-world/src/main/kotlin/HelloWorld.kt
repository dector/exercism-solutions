object HelloWorld {
    fun hello(name: String? = null): String {
        val greeter = if (name.isNullOrBlank()) "World" else name
        return "Hello, $greeter!"
    }
}