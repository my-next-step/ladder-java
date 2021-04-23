package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {

    @DisplayName("LadderHeight 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int height = 3;

        // when
        LadderHeight ladderHeight = LadderHeight.valueOf(height);

        // then
        assertThat(ladderHeight).isNotNull();
    }

}