import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    
    @Test
    public void testReverseString() {
        StringUtils stringUtils = new StringUtils();
        assertEquals("cba", stringUtils.reverse("abc"));
    }
}