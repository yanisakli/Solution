import java.util.*;

public class Solution {


    public <T> List<List<T>> partition(List<T> list, int length) throws EmptyOrNullException, LengthSubListException{
        List<List<T>> parts = new ArrayList<List<T>>();

        if(list == null)
            throw new EmptyOrNullException("La liste est null, veuillez ajouter des éléments!!!");

        if(list.isEmpty())
            throw new EmptyOrNullException("La liste est vide, veuillez ajouter des éléments!!!");

        if(length == 0)
            throw new LengthSubListException("La longueur des nouvelles sous-listes sont de longueur 0 !!");

        final int size = list.size();
        for (int i = 0; i < size; i += length) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(size, i + length)))
            );
        }

        return parts;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Solution solution = new Solution();

        try {

            System.out.println(solution.partition(numbers, 2));
            System.out.println(solution.partition(numbers, 3));
            System.out.println(solution.partition(numbers, 1));

        } catch (LengthSubListException e) {
            e.printStackTrace();
        } catch (EmptyOrNullException e) {
            e.printStackTrace();
        }

    }
}