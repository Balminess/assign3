package org.example;

public class MyString {

    public static int indexOfString(String s1, String s2, int pos) {
        // Check for null or empty strings
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return -1;
        }

        // Ensure valid starting position
        if (pos < 0 || pos >= s1.length()) {
            return -1;
        }

        // Iterate through s1 starting from pos
        for (int i = pos; i <= s1.length() - s2.length(); i++) {
            boolean match = true;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }

        // No occurrence of s2 found
        return -1;
    }

    public static String replace(String s, String s1, String s2) {
        // Check if any of the strings is null
        if (s == null || s1 == null || s2 == null)
            return null;

        // If s1 is empty, return s2
        if (s1.isEmpty())
            return s2;

        // Initialize a StringBuilder to store the modified string
        StringBuilder result = new StringBuilder();

        // Initialize the starting index
        int index = 0;

        // Iterate through the string s
        while (true) {
            // Find the index of s1 starting from the current position
            int startIndex = indexOfString(s, s1, index);

            // If s1 is found, append the substring from the current position to the found index
            // and append s2 instead of s1
            if (startIndex != -1) {
                result.append(s, index, startIndex);
                result.append(s2);
                // Move the index after the occurrence of s1
                index = startIndex + s1.length();
            } else {
                // If s1 is not found, append the remaining substring and break the loop
                result.append(s.substring(index));
                break;
            }
        }

        // Convert StringBuilder to String and return
        return result.toString();
    }


}
