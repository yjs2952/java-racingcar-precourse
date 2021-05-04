package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("tryMove() 호출시 결과 메시지 반환 하는지 검증한다")
    void drawTraceMessageTest() {
        // guven
        String players = "crong,poby,yoda";
        Cars cars = Cars.of(players);

        // when
        Traces traces = cars.tryMove(() -> true);
        String traceMessage = traces.draw();
        String expected = "crong:-\npoby:-\nyoda:-\n";

        // then
        assertThat(traceMessage).isEqualTo(expected);
    }

    @Test
    @DisplayName("tryMove() 호출시 우승자를 찾는지 검증한다")
    void findWinnersTest() {
        // guven
        String players = "crong,poby,yoda";
        Cars cars = Cars.of(players);

        // when
        Traces traces = cars.tryMove(() -> true);
        String winners = traces.findWinners();

        // then
        assertThat(winners).isEqualTo(players);
    }
}