/*
 * source
 * https://github.com/eugenp/tutorials/tree/master/algorithms/src/test/java/com/baeldung/algorithms/romannumerals
 */

//import static org.junit.Assert.assertThat;  /*does not work*/

/*
 * Rules:
There	were	certain	rules	that	the	numerals	followed	which	should	be	observed:
1. The	symbols	'I',	'X',	'C',	and	'M'	can	be	repeated	at	most	3	times	in	a row.
2. The	symbols	'V',	'L',	and	'D'	can	never	be repeated.
3. The '1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and	
'IX',	'XL'	and	'XC',	'CD'	and 'CM').
4. Only	one	subtraction	can	be	made	per	numeral	('XC'	is	allowed,	'XXC'	is not).
5. The	'5'	symbols	('V',	'L',	and	'D')	can	never	be subtracted

 */

import static org.junit.Assert.*;
import org.junit.Test;
public class TestRomanNumerals {

	@Test
	public void ItoOne() {

		String roman = "I";

		int result = RomanArabicConverter.romanToArabic(roman);

		assertEquals(result, 1);

	}
	
	
	
	@Test
	public void VtoFive() {

		String roman2018 = "V";

		int result = RomanArabicConverter.romanToArabic(roman2018);

		assertEquals(result, 5);

	}

	@Test
	public void given2018Roman_WhenConvertingToArabic_ThenReturn2018() {
		
		String roman = "MMXVIII";
		
		int result = RomanArabicConverter.romanToArabic(roman);
//		 assertThat(result).isEqualTo(2018); /*does not work*/

		assertEquals(result, 2018);
	}
	
	@Test
	public void XtoHundred() {

		String roman = "C";

		int result = RomanArabicConverter.romanToArabic(roman);

		assertEquals(result, 100);

	}
	
	@Test
	public void ShouldFail_IIII() {

		String roman = "IIII"; // IV correct
		int result = RomanArabicConverter.romanToArabic(roman);
		assertEquals(result, 4);

	}
	
	@Test
	public void ShouldFail_VV() {

		String roman = "VV"; // X is the right format 

		int result = RomanArabicConverter.romanToArabic(roman);

		assertEquals(result, 10);

	}
	@Test
	public void ShouldFail_IC() {

		String roman = "IC";// XCIX

		int result = RomanArabicConverter.romanToArabic(roman); 

		assertEquals(result, 99);

	}
	@Test
	public void ShouldFail_IIX() {

		String roman = "IIX"; //Should Fail VIII is correct format
		int result = RomanArabicConverter.romanToArabic(roman);
		assertEquals(result, 8);

	}
	
	@Test
	public void ShouldFailRule_VX() {

		String roman = "VX"; //V

		int result = RomanArabicConverter.romanToArabic(roman);

		assertEquals(result, 5);
	}
	
	@Test
	public void ShouldFailRule_XXC() {

		String roman = "XXC"; //80

		int result = RomanArabicConverter.romanToArabic(roman);

		assertEquals(result, 80);
	}
	@Test
	public void ShouldFailRule_IM() {

		String roman = "IM"; //999

		int result = RomanArabicConverter.romanToArabic(roman);

		assertEquals(result, 999);
	}
/*	@Test 
 * I could not get this to work. The solution provided gives me errors, not fault as I wished, 
 * but detects the faults and the error is shown as failure trace note
 * 
	public void ShouldFailRule_VX() throws IllegalArgumentException {

		String roman = "VX"; //V

                // Expects IllegalArgumentException to be thrown in the future...
                thrown.expect(java.lang.IllegalArgumentException.class);
		int result = RomanArabicConverter.romanToArabic(roman);
                // The execution doesn't really get here...
		assertEquals(result, 5);
	}*/
}