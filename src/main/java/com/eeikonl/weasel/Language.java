/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ken O'Neill 2014
 *
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.eeikonl.weasel;

public class Language {

    public static final char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
    'V', 'W', 'X', 'Y', 'Z', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
    'v', 'w', 'x', 'y', 'z', ',', '.', '\'', '\"', '_', '-', '?', ')', '(', '{', '}', '[', ']', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    '0', ':', ';' };

    public static void checkAllCharactersAreValid(final String weasel) {
        for (int x = 0; x < weasel.length(); x++) {
            final char charAt = weasel.charAt(x);
            boolean found = false;
            for (final char letter : alphabet) {
                if (letter == charAt) {
                    found = true;
                }
            }
            if (!found) {
                throw new RuntimeException("the character " + charAt + " is not in alphabet");
            }
    
        }
    
    }

}
