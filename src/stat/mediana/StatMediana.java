package stat.mediana;

import java.util.Arrays;

public class StatMediana {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int[] median = SMArrayUtils.getMedian(nums);
        System.out.println(Arrays.toString(median));
    }

}
