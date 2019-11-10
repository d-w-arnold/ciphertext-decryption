import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Abstract Class for Decryption of ciphertext encoded with a Cipher.
 *
 * @author David W. Arnold
 * @version 09/11/2019
 */
public abstract class Decrypt
{
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected String tess;
    protected String ciphertext;
    protected File cipherFile;
    protected char[] charAlphabet;

    public Decrypt(File tessFile, File cipherFile) throws IOException
    {

        tess = new BufferedReader(new FileReader(tessFile)).readLine();
        ciphertext = new BufferedReader(new FileReader(cipherFile)).readLine();
        this.cipherFile = cipherFile;
        setCharAlphabet(tessFile);
    }

    protected int findIndex(char[] arr, int t)
    {
        if (arr == null) {
            return -1;
        }
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (arr[i] == t) {
                return i;
            }
            i++;
        }
        return -1;
    }

    protected String getExercise(File file)
    {
        String cipherFileName = file.getName();
        return cipherFileName.substring(1, cipherFileName.length() - 4);
    }

    private void setCharAlphabet(File tess)
    {
        if (tess.getName().equals("tess26.txt")) {
            charAlphabet = alphabet.toCharArray();
        } else if (tess.getName().equals("tess27.txt")) {
            charAlphabet = (alphabet + "|").toCharArray();
        }
    }
}