package org.example;

import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Arrange: Create mock
        ExternalAPI mockApi = Mockito.mock(ExternalAPI.class);

        // Act: Use the service that calls mock
        Main service = new Main(mockApi);
        service.fetchData();

        // Assert: Verify interaction with mock
        verify(mockApi).getData();
    }
}
