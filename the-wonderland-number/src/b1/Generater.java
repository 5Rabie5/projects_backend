package b1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generater {
  List<Integer> integers = Arrays.asList(2, 3, 4, 5, 6);

public int generate(){
  int wonderlandNumberMultipliedBy2 = getListOfMultipliedByWonderlandNumber().get(0);
  return wonderlandNumberMultipliedBy2 /2;
}
  private   List<Integer> getListOfMultipliedByWonderlandNumber() {
    return IntStream.range(100000, 999999)
                    .mapToObj(this::getListOfMultipliedByPosibleNumber)
                    .filter(this::haveSameDigits)
                    .findFirst().get();
                   }

  private boolean haveSameDigits(List<Integer> numbers) {
    int firstNumber = sortNumberAscending(numbers.get(0)) ;
    return numbers.stream()
                  .map(this::sortNumberAscending)
                  .filter(e -> e.equals(firstNumber))
                  .count() == integers.size();
  }


  private List<Integer> getListOfMultipliedByPosibleNumber(int PossibleWonderlandNumber) {
    return integers.stream().map(integer -> integer * PossibleWonderlandNumber)

                   .collect(Collectors.toList());
  }


  private int sortNumberAscending(Integer number) {

    String result = Stream.of(String.valueOf(number).split(""))
                          .sorted()
                          .collect(Collectors.joining());
    return Integer.valueOf(result);
  }

}
