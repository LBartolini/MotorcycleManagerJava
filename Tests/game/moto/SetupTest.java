package game.moto;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.ValueNotInRangeException;

public class SetupTest {

	@Test
	public void testConstructorNoExceptionRaised() {
		try {
			Setup setup = new Setup(Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE);
		} catch (ValueNotInRangeException e) {
			fail();
		}
	}
	
	@Test
	public void testConstructorAltezzaAvantrenoLower() {
		try {
			Setup setup = new Setup(Setup.MIN_VALUE-1, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE);
			fail();
		} catch (ValueNotInRangeException e) {
			return;
		}
	}
	
	@Test
	public void testConstructorAltezzaAvantrenoHigher() {
		try {
			Setup setup = new Setup(Setup.MAX_VALUE+1, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE);
			fail();
		} catch (ValueNotInRangeException e) {
			return;
		}
	}
	
	@Test
	public void testConstructorAltezzaRetrotrenoLower() {
		try {
			Setup setup = new Setup(Setup.DEFAULT_VALUE, Setup.MIN_VALUE-1, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE);
			fail();
		} catch (ValueNotInRangeException e) {
			return;
		}
	}
	
	@Test
	public void testConstructorAltezzaRetrotrenoHigher() {
		try {
			Setup setup = new Setup(Setup.DEFAULT_VALUE, Setup.MAX_VALUE+1, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE);
			fail();
		} catch (ValueNotInRangeException e) {
			return;
		}
	}
	
	@Test
	public void testConstructorDurezzaSospensioniFrontaliLower() {
		try {
			Setup setup = new Setup(Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.MIN_VALUE-1, Setup.DEFAULT_VALUE);
			fail();
		} catch (ValueNotInRangeException e) {
			return;
		}
	}
	
	@Test
	public void testConstructorDurezzaSospensioniFrontaliHigher() {
		try {
			Setup setup = new Setup(Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.MAX_VALUE+1, Setup.DEFAULT_VALUE);
			fail();
		} catch (ValueNotInRangeException e) {
			return;
		}
	}
	
	@Test
	public void testConstructorDurezzaSospensioniPosterioriLower() {
		try {
			Setup setup = new Setup(Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.MIN_VALUE-1);
			fail();
		} catch (ValueNotInRangeException e) {
			return;
		}
	}
	
	@Test
	public void testConstructorDurezzaSospensioniPosterioriHigher() {
		try {
			Setup setup = new Setup(Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.DEFAULT_VALUE, Setup.MAX_VALUE+1);
			fail();
		} catch (ValueNotInRangeException e) {
			return;
		}
	}

}
