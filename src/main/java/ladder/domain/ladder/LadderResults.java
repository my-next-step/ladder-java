package ladder.domain.ladder;

import ladder.exception.StringListNullPointerException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class LadderResults {

    private final List<String> results;

    public static final LadderResults of(final String[] results) {
        return of(toList(results));
    }

    private static final List<String> toList(final String[] results) {
        return Arrays.stream(results).collect(Collectors.toList());
    }

    public static final LadderResults of(final List<String> results) {
        return new LadderResults(results);
    }

    private LadderResults(final List<String> results) {
        validateNull(results);
        this.results = results;
    }

    private final void validateNull(final List<String> results) {
        if (Objects.isNull(results)) {
            throw new StringListNullPointerException();
        }
    }

    public final String findByIndex(final int index) {
        return results.get(index);
    }

    public final int size() {
        return results.size();
    }
}
