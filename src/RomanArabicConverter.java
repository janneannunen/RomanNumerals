import java.util.List;
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
public class RomanArabicConverter {
	public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        String romanNumeralCheck="null";
        String romanErrorType="null";
        		
        int result = 0;
        
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } 
            
            else {
                i++;
            }
            
            /*The solution provided gives me errors, not fault as I wished, 
            * but detects the faults and the error is shown as failure trace note
            */
            
            romanNumeralCheck = romanNumeral;
            romanErrorType="IIII";
        
            if (romanNumeralCheck == romanErrorType){ 	
            	throw new IllegalArgumentException(romanNumeralCheck + " more than 3 I in a row");	
            }
            romanErrorType="XXXX";
            if (romanNumeralCheck == "XXXX"){ 	
            	throw new IllegalArgumentException(input + " more than 3 X in a row");	
            }
            romanErrorType="CCCC";
            if (romanNumeralCheck == "CCCC"){ 	
            	throw new IllegalArgumentException(input + " more than 3 C in a row");	
            }
            romanErrorType="MMMM";
            if (romanNumeralCheck == "MMMM"){ 	
            	throw new IllegalArgumentException(input + " more than 3 M in a row");	
            }
            romanErrorType="VV";
            if (romanNumeralCheck == "VV"){ 	
            	throw new IllegalArgumentException(input + " more than 2 V in a row");	
            }
            romanErrorType="LL";
            if (romanNumeralCheck == "LL"){ 	
            	throw new IllegalArgumentException(input + " more than 2 L in a row");	
            }
            romanErrorType="DD";
            if (romanNumeralCheck == romanErrorType){ 	
            	throw new IllegalArgumentException(input + " more than 2 D in a row");	
            }
        } 
        
        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }
             
        
        return result;
    }
	
/*
    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (number > 0 && i < romanNumerals.size()) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
  }*/  
}
