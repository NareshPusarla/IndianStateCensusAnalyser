package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/statecensus.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/statecensus.csv";
	
	@Test
	public void ifCorrect() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(3, numOfRecords);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void ifWrong() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
}
