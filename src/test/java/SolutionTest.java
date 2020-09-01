import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void should_Return_subLists_of_list() throws EmptyOrNullException, LengthSubListException {
        List<Integer> numbersList = Arrays.asList(1,2,3,4,5);
        List<Integer> subListFirst = Arrays.asList(1,2,3);
        List<Integer> subListSecond = Arrays.asList(4,5);
        List<List<Integer>> subLists = Arrays.asList(subListFirst,subListSecond);

        Assert.assertEquals(subLists,solution.partition(numbersList,3));
    }

    @Test(expected = EmptyOrNullException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws EmptyOrNullException, LengthSubListException {
        final List<Integer> numbersListEmpty = Arrays.asList();
        final List<Integer> numbersListNull = null;

        solution.partition(numbersListEmpty,3);
        solution.partition(numbersListNull,3);
    }

    @Test(expected = LengthSubListException.class)
    public void whenLengthSubListExceptionThrown_thenExpectationSatisfied() throws EmptyOrNullException, LengthSubListException {
        final List<Integer> numbersListEmpty = Arrays.asList(1,2,3);

        solution.partition(numbersListEmpty,0);
    }

}
