import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class VoidMethodTest {

    @Test
    public void testVoidMethod() {
        ExternalApi mockApi =
                Mockito.mock(ExternalApi.class);

        doNothing()
                .when(mockApi)
                .sendData("Hello");

        MyService service =
                new MyService(mockApi);

        service.sendData("Hello");

        verify(mockApi)
                .sendData("Hello");
    }
}