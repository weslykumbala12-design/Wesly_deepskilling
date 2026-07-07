import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArgumentMatchingTest {

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi =
                Mockito.mock(ExternalApi.class);

        when(mockApi.getDataById(anyInt()))
                .thenReturn("Customer Data");

        MyService service =
                new MyService(mockApi);

        service.fetchDataById(10);

        verify(mockApi)
                .getDataById(10);
    }
}