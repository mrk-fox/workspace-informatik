public class DJB2Hash {
    
    /**
     * Computes the DJB2 hash value for a given string.
     * 
     * @param str the input string to hash
     * @return the hash value as a long
     */
    public static long hash(String str) {
        if (str == null) {
            return 0;
        }
        
        long hash = 5381;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            hash = ((hash << 5) + hash) + c; // hash * 33 + c
        }
        
        return hash;
    }
    
    /**
     * Computes the DJB2 hash and returns it as a hexadecimal string.
     * 
     * @param str the input string to hash
     * @return the hash value as a hexadecimal string
     */
    public static String hashToHex(String str) {
        long hash = hash(str);
        return String.format("0x%x", hash);
    }
    
}
