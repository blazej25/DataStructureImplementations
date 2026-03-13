import CustomExceptions.EmptyListException;
import Heap.*;
import Lists.DynamicList.DynamicListArray;
import Lists.DynamicList.List;
import Sorts.Sort;

public class Main {

    static void main() throws EmptyListException {
        int[] arr = new int[]{6, 1, 0, 5, 6, 7};
        Sort.quickSort(arr);
    }
}
