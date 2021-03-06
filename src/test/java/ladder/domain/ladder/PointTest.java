package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointTest {


    @DisplayName("Point 인스턴스가 첫번째 Point를 반환하는 기능 테스트")
    @Test
    void 기능_첫번째_포인트_반환() {

        // when and then
        assertAll(
                () -> assertThat(Point.first(TRUE).move()).isEqualTo(1),
                () -> assertThat(Point.first(FALSE).move()).isEqualTo(0)
        );
    }

    @DisplayName("Point 인스턴스가 마지막 Point를 반환하는 기능 테스트")
    @Test
    void 기능_마지막_포인트_반환() {
        // when and then
        assertThat(Point.first(TRUE).last().move()).isEqualTo(0);
        assertThat(Point.first(FALSE).last().move()).isEqualTo(1);
    }

    @DisplayName("Point 인스턴스가 제자리로 이동하는지 테스트")
    @Test
    public void 기능_제자리_이동() {
        Point point = Point.first(FALSE);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("Point 인스턴스가 왼쪽으로 이동하는지 테스트")
    @Test
    public void 기능_왼쪽으로_이동() {
        Point point = Point.first(TRUE).last();
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("Point 인스턴스가 오른쪽으로 이동하는지 테스트")
    @Test
    public void 기능_오른쪽으로_이동() {
        Point point = Point.first(TRUE);
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("Point 인스턴스가 이전이 TRUE 일때, 다음 Point를 반환하는 기능 테스트")
    @Test
    void 기능_다음_포인트_반환_이전이_TRUE() {
        assertThat(Point.first(TRUE).next(() -> false).move()).isEqualTo(0);
    }

    @DisplayName("Point 인스턴스가 값을 기준으로 동일한지 판단 여부 테스트")
    @Test
    void 비교() {
        Point actual = Point.first(TRUE);
        Point expected = Point.first(TRUE);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Point 인스턴스가 왼쪽으로 이동하는지 확인 여부 테스트")
    @Test
    void 비교_특정_포인트_왼쪽_이동_확인() {
        Point actualOne = Point.first(TRUE).next(() -> FALSE);
        Point actualTwo = Point.first(FALSE).next(() -> TRUE).next(() -> false);

        assertAll(
                () -> assertThat(actualOne.isLeft()).isTrue(),
                () -> assertThat(actualTwo.isLeft()).isTrue());
    }

}