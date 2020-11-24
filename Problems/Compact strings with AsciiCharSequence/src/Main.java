import java.util.*;

class AsciiCharSequence implements CharSequence {

    private byte[] sequence;

    public AsciiCharSequence(byte[] sequence) {
        this.sequence = sequence.clone();
    }

    @Override
    public int length() {
        return this.sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) this.sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(this.sequence, start, end));
    }

    @Override
    public String toString() {
        return new String(this.sequence);
    }
}