package Lists.DynamicList;

public class DynamicListArrayTest extends ListTest{

    @Override
    protected List<Integer> createList() {
        return new DynamicListArray<>();
    }
}
