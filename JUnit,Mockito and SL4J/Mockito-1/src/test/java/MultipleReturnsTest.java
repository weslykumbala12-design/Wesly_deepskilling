import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class MultipleReturnsTest {

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi =
                Mockito.mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn(
                        "First Data",
                        "Second Data",
                        "Third Data"
                );

        MyService service =
                new MyService(mockApi);

        assertEquals(
                "First Data",
                service.fetchData()
        );

        assertEquals(
                "Second Data",
                service.fetchData()
        );

        assertEquals(
                "Third Data",
                service.fetchData()
        );
    }
}