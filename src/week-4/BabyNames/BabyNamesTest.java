import static org.junit.Assert.*;

public class BabyNamesTest {
    BabyNames obj = new BabyNames();
    @org.junit.Test
    public void getRank() {
        int rank = obj.getRank(1967,"Lisa","F");
        assertEquals(1,rank);
        //assertFalse(rank < 0);
        //fail();
    }
}