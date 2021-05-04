package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4,1", "9,1", "3,0"})
    @DisplayName("숫자가 4 이상인 경우 전진, 작은 경우 정지한다.")
    void moveTest(int number, int expected) {
        Car car = Car.of("poby", () -> number);
        int distance = car.move();
        assertThat(distance).isEqualTo(expected);
    }
}