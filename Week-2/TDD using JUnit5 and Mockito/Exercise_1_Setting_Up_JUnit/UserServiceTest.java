import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;
    
    @Test
    public void testGetUserById() {
        User mockUser = new User(1, "John Doe");
        when(userRepository.findById(1)).thenReturn(mockUser);
        
        User result = userService.getUserById(1);
        
        assertEquals("John Doe", result.getName());
        verify(userRepository, times(1)).findById(1);
    }
}