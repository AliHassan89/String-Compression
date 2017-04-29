/*
 *  String Compression: Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
    "compressed" string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
package cci_chap1_compression;

/**
 *
 * @author Ali
 */
public class CCI_Chap1_Compression 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println(compress("abcdeeeeeee"));
    }
    
    private static String compress(String str)
    {
        if(str.length() <= 2)
            return str;
        
        int count = 0;
        char prev = '\0';
        String compressed = "";
        
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i) == prev || prev == '\0')
            {
                prev = str.charAt(i);
                count++;
            }
            else
            {
                compressed += prev + Integer.toString(count);
                count = 1; 
                prev = str.charAt(i);
            }
        }
        
        compressed += prev + Integer.toString(count);
        
        if(compressed.length() > str.length())
            return str;
        
        return compressed;
    }
}
