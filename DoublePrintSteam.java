import java.io.*;

/**
 * Generic version of the DoublePrintSteam class.
 */
public class DoublePrintSteam extends PrintStream {
    private final OutputStream fos;
    /**
     * constructor for DoublePrintSteam
     */
    DoublePrintSteam(OutputStream out, String fileName) {
        super(out);
        try {
            fos = new FileOutputStream(new File(fileName));

        } catch (FileNotFoundException e) {
            throw new AssertionError("can't creat file", e);
        }
    }

    /**
     * override method to display to console and file at the same time
     * @param buf
     * @param off
     * @param len
     */
    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);

        try {
            fos.write(buf, off, len);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * override close method
     */
    @Override
    public void close() {
        try {
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            super.close();
        }
    }
}
