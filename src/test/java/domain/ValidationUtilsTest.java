package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"gandalf,false", ",false", "k,true", "jason,true"})
    @MethodSource("provideCarNamesForLength")
    @DisplayName("자동차 이름의 길이가 1 ~ 5 사이인지 검증한다")
    void validateCarNameLength(String carName, boolean expected) {
        assertThat(ValidationUtils.validCarName(carName)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideCarNamesForNullAndBlank")
    @DisplayName("입력값에 null 또는 공백이 있는지 검증한다.")
    void validateCarNamesTest(String carNames, boolean expected) {
        assertThat(ValidationUtils.validCarNames(carNames)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"poby,crong:true", "poby:false"}, delimiter = ':')
    @DisplayName("자동차 이름이 2개 이상인지 검증한다.")
    void validateHasOverTwoCarsTest(String carNames, boolean expected) {
        assertThat(ValidationUtils.validCarNames(carNames)).isEqualTo(expected);
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
                Arguments.of("poby,crong", true),
                Arguments.of(null, false),
                Arguments.of("toby,crong ", false),
                Arguments.of("jo hn,paul", false),
                Arguments.of(" jin,law", false),
                Arguments.of("", false)
                );
    }
}