import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {


    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {

        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: "
                    + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        double[] gpas = new double[studentIdList.length];

        for (int i = 0; i < studentIdList.length; i++) {
            int totalPoints = 0;
            int numCourses = studentsGrades[i].length;
            for (int j = 0; j < numCourses; j++) {
                if (studentsGrades[i][j] == ' ') {
                    throw new MissingGradeException(studentIdList[i]);
                }
                switch (studentsGrades[i][j]) {
                    case 'A':
                        totalPoints += 4;
                        break;
                    case 'B':
                        totalPoints += 3;
                        break;
                    case 'C':
                        totalPoints += 2;
                        break;
                    default:
                        totalPoints += 1;
                        break;
                }
            }
            gpas[i] = (double) totalPoints / numCourses;
        }
        return gpas;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpas;
        try {
            gpas = calculateGPA(studentIdList, studentsGrades);
        } catch (MissingGradeException e) {
            throw new InvalidDataException("Invalid data encountered while calculating GPA", e);
        }

        int count = 0;
        for (double gpa : gpas) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] students = new int[count];
        int j = 0;
        for (int i = 0; i < gpas.length; i++) {
            if (gpas[i] >= lower && gpas[i] <= higher) {
                students[j] = studentIdList[i];
                j++;
            }
        }

        return students;
    }


    public static <T> void exchangeElements(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid index");
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static Set<Book> treeSetDemo(Comparator<Book> comparator) {
        Set<Book> books;
        if (comparator == null) {
            books = new TreeSet<>();
        } else {
            books = new TreeSet<>(comparator);
        }


        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);

        books.add(book1);


        return books;
    }

    public static void main(String[] args) {
        Set<Book> naturalOrderingSet = treeSetDemo(null);
        for (Book book : naturalOrderingSet) {
            System.out.println(book);
        }
        Set<Book> ascOrderingSet = treeSetDemo(new PubDateAscComparator());
        for (Book book : ascOrderingSet) {
            System.out.println(book);
        }

        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"apple", "banana", "cherry", "date"};

        System.out.println("Original Integer array: " + Arrays.toString(intArray));
        exchangeElements(intArray, 1, 2);
        System.out.println("After exchanging: " + Arrays.toString(intArray));
    }


}