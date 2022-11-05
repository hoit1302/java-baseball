package baseball.domain;

import baseball.util.Number;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void redefineNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void guessNumbers() {
        OutputView.printInputRequest();
        String input = InputView.inputString();
        checkInput(input);
        redefineNumbers(convertInput(input));
    }

    void checkInput(String input) {
        if (!Objects.equals(input.length(), Number.PRESCRIBED_DIGITS)) {
            throw new IllegalArgumentException();
        }

        List<Character> used = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException();
            }
            if (Objects.equals(Number.ZERO, ch)) {
                throw new IllegalArgumentException();
            }
            if (used.contains(ch)) {
                throw new IllegalArgumentException();
            }
            used.add(ch);
        }
    }

    List<Integer> convertInput(String input) {
        List<Integer> convertedIntegers = new ArrayList<>();
        for (char ch: input.toCharArray()) {
            convertedIntegers.add(Character.getNumericValue(ch));
        }
        return convertedIntegers;
    }
}
