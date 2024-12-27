import io.ktor.server.application.*
import io.ktor.server.testing.*
import kotlin.test.Test

class KBannerTest {

    @Test
    fun `default banner print`() = testApplication {
        application {
            install(KBanner)
        }
    }

    @Test
    fun `custom banner print`() = testApplication {
        application {
            install(KBanner) {
                location = "nahida.txt"
            }
        }
    }
}