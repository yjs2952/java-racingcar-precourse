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
    @MethodSource("provideCarNamesForLength")
    @DisplayName("자동차 이름의 길이가 1 ~ 5 사이인지 검증한다")
    void validateCarNameLength(String carName, boolean expected) {
        assertCarName(carName, expected);
    }

    @ParameterizedTest
    @MethodSource("provideCarNamesForNullAndBlank")
    @DisplayName("자동차 이름에 null 또는 공백이 있는지 검증한다")
    void validateCarNameHasNullOrBlank(String carName, boolean expected) {
        assertCarName(carName, expected);
    }

    private void assertCarName(String carName, boolean expected) {
        assertThat(ValidationUtils.validCarName(carName)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCarNamesForLength() {
        return Stream.of(
                Arguments.of("jason", true),
                Arguments.of("k", true),
                Arguments.of("gandalf", false),
                Arguments.of("", false),
                Arguments.of(" jn", false)
        );
    }

    private static Stream<Arguments> provideCarNamesForNullAndBlank() {
        return Stream.of(
                Arguments.of("poby", true),
                Arguments.of(null, false),
                Arguments.of("toby ", false),
                Arguments.of("jo hn", false),
                Arguments.of(" jn", false)
                );
    }
}