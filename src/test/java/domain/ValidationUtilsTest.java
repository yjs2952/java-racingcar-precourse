package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"gandalf,false", ",false", "k,true", "jason,true"})
    @MethodSource("provideNamesForLength")
    @DisplayName("이름의 길이가 1 ~ 5 사이인지 검증한다")
    void validateDriverNameLength(String driverName, boolean expected) {
        assertThat(ValidationUtils.validDriverName(driverName)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNamesForLength() {
        return Stream.of(
                Arguments.of("jason", true),
                Arguments.of("k", true),
                Arguments.of("gandalf", false),
                Arguments.of("", false),
                Arguments.of(" jn", false)
        );
    }

}