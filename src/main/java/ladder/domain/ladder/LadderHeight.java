package ladder.domain.ladder;

import ladder.exception.InputNegativeNumberException;

public final class LadderHeight {

    private static final int ZERO = 0;

    private final int height;

    public static LadderHeight valueOf(final int height) {
        return new LadderHeight(height);
    }

    private LadderHeight(final int height) {
        validateNegative(height);
        this.height = height;
    }

    private final void validateNegative(final int height) {
        if (height < ZERO) {
            throw new InputNegativeNumberException(height);
        }
    }

    public final int height() {
        return height;
    }
}
