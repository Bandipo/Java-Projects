import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConfigParserTest {
    ConfigParser config;

    @Test
    @BeforeEach
    public void setUp() throws Exception {


        config = new ConfigParser("src/main/resources/config.txt.dev");
    }

    @Test
    void configReaderTest() {
        config.configReader();
        assertTrue(config.getConfigMap().size() > 5);
    }


    @Test

    void configKeyTest() {
        String expected = "name : fintrack-development";
        assertEquals(expected, config.configKey("name"));
    }

    @Test
    void getConfigMapTest(){
        config.configReader();
        assertTrue(config.getConfigMap().size() > 5);
    }
}