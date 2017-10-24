import org.junit.Test;
import pages.RubberDucksPage;
import utils.DBHelper;

import java.sql.SQLException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class DucksNamesTest {

    @Test
    public void duckNamesShouldBeEqualToDB() throws SQLException {
        RubberDucksPage ducksPage = new RubberDucksPage();
        List<String> duckNamesFromUI = ducksPage.getDuckNames();
        List<String> duckNamesFromDB = DBHelper.getProductNames();

        assertEquals(duckNamesFromDB, duckNamesFromUI);
    }
}
