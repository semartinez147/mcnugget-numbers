package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

class FrobeniusTest {

  private static Stream<Arguments> provideDataForGeneralMcNuggetAffirmative() {
    return Stream.of(
        Arguments.of(29, new int[] {20, 9, 2}),
        Arguments.of(30, new int[] {11, 7, 5}),
        Arguments.of(37, new int[] {11, 7, 5}),
        Arguments.of(216, new int[] {50, 8}),
        Arguments.of(98, new int[] {50, 8})
    );
  }
  
  private static Stream<Arguments> provideDataForGeneralMcNuggetNegative() {
    return Stream.of(
        Arguments.of(1, new int[] {20, 9, 2}),
        Arguments.of(9, new int[] {11, 7, 5}),
        Arguments.of(6, new int[] {11, 7, 5}),
        Arguments.of(115, new int[] {50, 8}),
        Arguments.of(201, new int[] {50, 8})
    );
  }

  @ParameterizedTest
  @CsvFileSource(resources = "mcnugget-data.csv", numLinesToSkip = 1)
    void isMcNugget(int value, boolean expected) {
  assertEquals(expected, Frobenius.isMcNugget(value));
  }

  @ParameterizedTest
  @MethodSource("provideDataForGeneralMcNuggetAffirmative")
  void isGeneralMcNugget_affirmative(int value, int[] packSizes) {
    assertTrue(Frobenius.isGeneralMcNugget(value, packSizes));
  }
  @ParameterizedTest
  @MethodSource("provideDataForGeneralMcNuggetNegative")
  void isGeneralMcNugget(int value, int[] packSizes) {
    assertFalse(Frobenius.isGeneralMcNugget(value, packSizes));
  }

}
