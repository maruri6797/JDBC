package mockitotest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import unittest.Calculator;

@ExtendWith(MockitoExtension.class)
class MockitoSampleTest {
	
	@Mock
	private Calculator calc;
	
	@InjectMocks
	private MockitoSample sample;

	 @Test
	 @DisplayName("getSquareResultに5を渡したときに25が表示できる")
	 void test() {
		  when(calc.square(5)).thenRerutn(25);
		  String result = sample.getSquareResult(5);
		  assertEquals(result, "5の二乗の結果は25");
	 }
}
