package utils

fun initialization() {
    ConfigManager.initialization()
}

fun getToken(): String {
    return ConfigManager.getConfig("token").let { it?.toString() ?: "" }
}

fun getApiKey(): String {
    return ConfigManager.getConfig("apikey").let { it?.toString() ?: "" }
}