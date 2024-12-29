import io.ktor.server.application.*
import java.io.BufferedReader
import java.io.InputStreamReader

class KBannerConfig {
    var location: String = "banner.txt"
}

val KBanner = createApplicationPlugin(
    name = "KBanner",
    createConfiguration = ::KBannerConfig
) {
    var banner = """
        '##:::'##:'########::'#######::'########::
         ##::'##::... ##..::'##.... ##: ##.... ##:
         ##:'##:::::: ##:::: ##:::: ##: ##:::: ##:
         #####::::::: ##:::: ##:::: ##: ########::
         ##. ##:::::: ##:::: ##:::: ##: ##.. ##:::
         ##:. ##::::: ##:::: ##:::: ##: ##::. ##::
         ##::. ##:::: ##::::. #######:: ##:::. ##:
        ..::::..:::::..::::::.......:::..:::::..::
    """.trimIndent()

    val sb = StringBuilder()
    val location = pluginConfig.location
    object {}.javaClass.getResourceAsStream("/${location}")?.let { inputStream ->
        BufferedReader(InputStreamReader(inputStream)).use { reader ->
            reader.lines().forEach {
                sb.append(it + "\n")
            }
        }
        banner = sb.toString()
    }

    println("\n${banner}\n")
}