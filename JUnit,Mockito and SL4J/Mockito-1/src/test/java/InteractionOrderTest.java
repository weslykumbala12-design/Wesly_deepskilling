import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class InteractionOrderTest {

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi =
                Mockito.mock(ExternalApi.class);

        MyService service =
                new MyService(mockApi);

        service.processInOrder();

        InOrder inOrder =
                Mockito.inOrder(mockApi);

        inOrder.verify(mockApi)
                .connect();

        inOrder.verify(mockApi)
                .getData();

        inOrder.verify(mockApi)
                .disconnect();
    }
}