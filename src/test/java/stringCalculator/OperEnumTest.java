package stringCalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperEnumTest {

    @Test
    void of() {
        assertThat(OperEnum.of("+")).isEqualTo(OperEnum.PLUS);
        assertThat(OperEnum.of("-")).isEqualTo(OperEnum.MINUS);
        assertThat(OperEnum.of("*")).isEqualTo(OperEnum.MULTIPLE);
        assertThat(OperEnum.of("/")).isEqualTo(OperEnum.DIVIDE);
    }

    @ParameterizedTest
    //delimiter ' single
    @CsvSource(value = {"3/0", "4/0"}, delimiter = '/')
    void divideByZero(int first, int second){
        assertThatThrownBy(() -> {
            OperEnum.DIVIDE.operate(first, second);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
