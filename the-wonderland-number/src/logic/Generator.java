package logic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generator {

  private final List<Integer> multipliedNumbers = Arrays.asList(2, 3, 4, 5, 6);

  public int generate() {
    int wonderlandNumberMultipliedBy2 = getListOfMultipliedByWonderlandNumber().get(0);
    return wonderlandNumberMultipliedBy2 / 2;
  }

  private List<Integer> getListOfMultipliedByWonderlandNumber() {

    return IntStream.range(100000, 999999)
                    .mapToObj(this::getListOfMultipliedByPossibleNumber)
                    .filter(this::haveSameDigits)
                    .findFirst().get();
  }

  private List<Integer> getListOfMultipliedByPossibleNumber(int possibleWonderlandNumber) {
    return multipliedNumbers.stream().map(integer -> integer * possibleWonderlandNumber)
                            .collect(Collectors.toList());
  }

  public boolean haveSameDigits(List<Integer> numbers) {
    int firstNumber = sortNumberAscending(numbers.get(0));
    return numbers.stream()
                  .map(this::sortNumberAscending)
                  .allMatch(e -> e.equals(firstNumber));
  }

  public int sortNumberAscending(Integer number) {
    String sortedNumber = Stream.of(String.valueOf(number).split(""))
                                .sorted()
                                .collect(Collectors.joining());
    return Integer.valueOf(sortedNumber);
  }
}
