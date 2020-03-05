package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class AlgorithmsTest {

  @ParameterizedTest
  @CsvFileSource(resources = "gcd-data.csv", delimiter = '\t')
  void gcd(long a, long b, long expected) {
    assertEquals(expected, Algorithms.gcd(a, b));
  }

  @Test
  void gcdException() {
    assertThrows(IllegalArgumentException.class, () -> Algorithms.gcd(0, 0));
  }

  @Test
  void gcdVarArgs() {
  }

}
