package nsu.trushkov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainTest {

    @Test
    void main_correctWork() {
        try(MockedStatic mockedStatic = Mockito.mockStatic(Main.class, Mockito.CALLS_REAL_METHODS)) {

            //when
            Main.main(new String[]{});

            //then
            mockedStatic.verify(() -> Main.main(new String[]{}));
        }
    }
}