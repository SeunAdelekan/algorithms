package random.bitmanipulation;

/**
 * @author Iyanu Adelekan on 31/08/2018.
 */
public class CommonOperations {

    private boolean getBit(int num, int position) {
        return (num & 1 << position) != 0;
    }

    private int setBit(int num, int position) {
        return num | 1 << position;
    }

    private int clearBit(int  num, int position) {
        int mask = ~(1 << position);
        return num & mask;
    }

    private int clearBitsMSBthroughPosition(int num, int position) {
        int mask = (1 << position) - 1;
        return num & mask;
    }

    private int clearBitsPositionThrough0(int num, int position) {
        int mask = (-1 << position + 1);
        return num & mask;
    }

    private int updateBit(int num, int position, boolean val) {
        int mask = ~(1 << position);
        num &= mask;
        return num | ((val ? 1 : 0) << position);
    }
}
