package smarthome.security.test.util;

import java.util.UUID;

public class StringUtils {
	/**
     * <p>Checks if a CharSequence is whitespace, empty ("") or null.</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace
     * @since 2.0
     * @since 3.0 Changed signature from isBlank(String) to isBlank(CharSequence)
     */
	
	// 允许中间有空字符
    public static boolean isEmpty(final String str) {
    	String str1=str.trim();
        int strLen=str1.length();
        if (str1 == null || strLen == 0) {
            return true;
        }
        return true;
    }
    
    // 不允许有空字符
    public static boolean isBlank(final CharSequence cs) {
    	int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
    	return true;
    }
    
    public static String uid() {
		return UUID.randomUUID().toString().replace("-", "");
	}    
}
