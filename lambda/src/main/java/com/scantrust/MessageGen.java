package com.scantrust;

/**
 * Generates the message digest from a list of bits and values.
 */
public class MessageGen {

    /**
     * Process for converting the values works like this:
     * - Convert each "value" to an int, then to a binary string (13 = > 1101)
     * - Pad the binary string with zeros
     * - Combine all the strings
     * - Take chunks of 5, and convert to a character
     *
     * @param bits   Array of bit lengths, one for each value
     * @param values Array of values.  Will be converted to an int by Math.round
     * @return String containing the message
     */
    public static String generateMessage(int[] bits, double[] values) {
        StringBuilder binaryString = new StringBuilder(512);
        for (int i = 0; i < values.length; i++) {
            binaryString.append(formatField((int) Math.round(values[i]), bits[i]));
        }

        StringBuilder result = new StringBuilder(50);
        for (String chunk : Util.splitEqually(binaryString.toString(), 5)) {
            result.append(Util.chars[Integer.valueOf(chunk, 2)]);
        }
        return result.toString();
    }

    public static String formatField(int value, int bitCount) {
        String binaryStr = Integer.toBinaryString(value); // 9 => 1001
        if (binaryStr.length() < bitCount) {
            return Util.zeros[bitCount - binaryStr.length()] + binaryStr;  // left pad string if needed
        }
        return binaryStr;
    }

}
