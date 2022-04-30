package stat.mediana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SMArrayUtils {

    public static SMArrayType getArrayType(ArrayList<Integer> array) {
        return (array.size() % 2 == 0) ? SMArrayType.EVEN : SMArrayType.ODD;
    }

    public static SMArrayType getArrayType(int[] array) {
        return (array.length % 2 == 0) ? SMArrayType.EVEN : SMArrayType.ODD;
    }

    public static int[] getMedian(ArrayList<Integer> array) {
        Collections.sort(array);
        int[] returnVal = new int[2];
        if(getArrayType(array) == SMArrayType.EVEN) {
            int middle = array.size() / 2;
            ArrayList<Integer> subArray1 = new ArrayList<>(array.subList(0, middle));
            ArrayList<Integer> subArray2 = new ArrayList<>(array.subList(middle, array.get(-1)));
            returnVal[0] = subArray1.get(-1);
            returnVal[1] = subArray2.get(1);
        }else if(getArrayType(array) == SMArrayType.ODD) {
            int middle = array.size() / 2;
            returnVal[0] = middle;
        }
        return returnVal;
    }

    public static int[] getMedian(int[] array) {
        Arrays.sort(array);
        if(getArrayType(array) == SMArrayType.EVEN) {
            int[] returnVal = new int[2];
            int middle = array.length / 2;
            int[] subArray1 = Arrays.copyOfRange(array, 0, middle);
            int[] subArray2 = Arrays.copyOfRange(array, middle, array[array.length-1]);
            returnVal[0] = subArray1[subArray1.length-1];
            returnVal[1] = subArray2[subArray2[0]];
            return returnVal;
        }else if(getArrayType(array) == SMArrayType.ODD) {
            int[] one = new int[1];
            one[0] = array[0] + (array[array.length-1]-array[0])/2;
            return one;
        }
        return new int[0];
    }

}
