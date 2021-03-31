public class Galua256 {
    private final byte line;
    public Galua256(byte line) {
        this.line = line;
    }

    public byte add(byte a, byte b) {
        return (byte) (a ^ b);
    }

    public byte multi(byte a, byte b) {
        byte mult = 0;

        for (int i = 0; i < 8; i++) {
            if ((b & 1) != 0) {
                mult^= a;
            }
            byte c = (byte) (a & 0x80);
            a <<= 1;
            if (c != 0) {
                a ^= line;
            }
            b >>= 1;
        }

        return mult;
    }
}