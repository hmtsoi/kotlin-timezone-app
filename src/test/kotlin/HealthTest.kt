import com.thmlogwork.timezone.app.domain.Health
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unitTest")
class HealthTest {

    @Test
    fun `return correct message successfully`() {

        val health = Health()
        assertThat(health.health).isEqualTo("ok")
    }

}