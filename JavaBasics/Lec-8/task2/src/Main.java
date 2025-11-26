
void main() {

    List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);

    List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

    List<Student> students = Arrays.asList(
            new Student("Ali", "IT", 85),
            new Student("Mona", "CS", 92),
            new Student("Ahmed", "IT", 60),
            new Student("Sara", "CS", 70),
            new Student("Omar", "IS", 45),
            new Student("Laila", "IS", 78)
    );

    List<Employee> employees = Arrays.asList(
            new Employee("Ali", 30, "HR", 5000),
            new Employee("Mona", 25, "IT", 7000),
            new Employee("Ahmed", 30, "HR", 5500),
            new Employee("Sara", 27, "IT", 7200),
            new Employee("Omar", 40, "Finance", 8000),
            new Employee("Laila", 35, "Finance", 8200)
    );

    List<List<String>> nestedWords = Arrays.asList(
            Arrays.asList("Java", "Stream"),
            Arrays.asList("API", "Lambda"),
            Arrays.asList("FlatMap", "Map")
    );

    List<Optional<String>> optionals = List.of(
            Optional.of("Amir"),
            Optional.empty(),
            Optional.of("Sara"),
            Optional.empty()
    );


                                    /*Basic Stream Operations*/

    /* Filter even numbers from a list of integers.*/
    List<Integer> task1 = numbers.stream().filter(n -> n % 2 == 0).toList();

    /* Find names starting with a specific letter from a list of strings */
    List<String> task2 = names.stream()
            .filter(n ->  n != null && !n.isEmpty() && n.charAt(0) == 'A' ).toList();

    /*Convert all strings to Lowercase using stream*/
    List<String> task3 = names.stream().filter(n -> n != null && !n.isEmpty())
            .map(String::toLowerCase).toList();

    /*Sort a list of integers in descending order using streams*/
    List<Integer> task4 = numbers.stream().distinct().sorted(Comparator.reverseOrder()).toList();

    /*Remove duplicate elements from a list using distinct()*/
    List<Integer> task5 = numbers.stream().distinct().toList();


                                    /*Intermediate Stream Tasks*/

    /*Count the number of strings longer than 5 characters*/
    long task6 = names.stream().filter(n -> n != null && n.length() > 5).count();

    /*Find the first element in a stream that matches a given condition*/
    String task7 = names.stream().filter(n -> n != null && n.length() == 5)
            .findFirst().orElse(null);

    /*Check if any number is divisible by 5 in a list*/
    Boolean task8 = numbers.stream().anyMatch(n -> n % 5 == 0 );

    /*Collect elements into a Set instead of a List*/
    Set<Integer> task9 = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());

    /*Skip the first 3 elements and return the rest*/
    List<String> task10 = names.stream().skip(3).toList();

                                    /*Numeric Streams & Reductions*/

    /*Calculate the sum of a list of integers using reduce.*/
    int task11 = numbers.stream().reduce(0, Integer::sum );

    /*Find the maximum and minimum value in a list*/
    int max = numbers.stream().max(Integer::compareTo).get();
    int min = numbers.stream().min(Integer::compareTo).get();

    /*Calculate the average of a list of doubles*/
    double task13 = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);

    /*Multiply all integers in a list together using reduce*/
    int task14 = numbers.stream().reduce(1, (x, y) -> x * y);

    /*Count how many numbers are positive in a list*/
    long task15 = numbers.stream().filter(n -> n > 0).count();

                                  /*Collectors & Grouping*/

    /*Group a list of students by their department*/
    Map<String, List<Student>> task16 = students.stream()
        .collect(Collectors.groupingBy(Student::getDepartment));

    Map<String, Long> task16_1 = students.stream()
            .collect(Collectors.groupingBy(Student::getDepartment,Collectors.counting()));

    Map<String, List<Double>> task16_2 = students.stream()
            .collect(Collectors.groupingBy(Student::getDepartment,Collectors
                    .mapping(Student::getGrade, Collectors.toList())));

    /*Partition a list of numbers into even and odd using partitioningBy*/
    Map<Boolean,List<Integer>> task17 = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n%2 == 0 , Collectors.toList()));

    /*Create a comma-separated string from a list of strings*/
    String task18 = names.stream().filter(n -> n != null && !n.isEmpty())
            .collect(Collectors.joining(", "));

    /*Group employees by age and count how many per age*/
    Map<Integer,Long> task19 = employees.stream()
            .collect(Collectors.groupingBy(Employee::getAge,Collectors.counting()));

    /*Find the average salary per department in a list of employees*/
    Map<String,Double> task20 = employees.stream()
            .collect(Collectors.groupingBy
                    (Employee::getDepartment , Collectors.averagingDouble(Employee::getSalary)));

                                    /*Optional, Map, FlatMap*/

    /*Flatten a list of lists into a single list.*/
    List<String> flatlist = nestedWords.stream().flatMap(Collection::stream).toList();

    /*Extract all unique characters from a list of words*/
    List<Character> task22 = flatlist.stream().flatMap(word -> word.chars()
                    .mapToObj(c -> (char) c)).distinct().toList();

    /*Filter a list of Optionals and collect non-empty values*/
    List<String> task23 = optionals.stream().filter(Optional::isPresent).map(Optional::get).toList();

    /*Map a list of strings to their lengths.*/
    Map<String,Integer> task24 =  names.stream().filter(n -> n != null && !n.isEmpty())
            .collect(Collectors.toMap(
                    n -> n,
                    String::length
            ));

    /*Return a list of uppercased words that start with “A”*/
    List<String> task25 = names.stream().filter(n -> n != null &&  n.startsWith("A")).toList();

                                        /*Advanced Operations*/
    /*Sort a list of employees by salary then by name*/
    Map<String , Double> task26 = employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary))
            .collect(Collectors.toMap(
                    Employee::getName,
                    Employee::getSalary,
                    (a, b) -> a,
                    LinkedHashMap::new
            ));

    Map<String , Double> task26_1 = employees.stream()
            .sorted(Comparator.comparing(Employee::getName))
            .collect(Collectors.toMap(
                    Employee::getName,
                    Employee::getSalary,
                    (a, b) -> a,
                    LinkedHashMap::new
            ));

    /*Find the second highest number in a list*/
    int task27 = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);

    /*Find duplicate elements in a list of integers.*/
    Set<Integer> set = new HashSet<>();
    Set<Integer> task28 = numbers.stream().filter(n -> !set.add(n) ).collect(Collectors.toSet());

    /*Remove null or empty strings from a list using stream*/
    List<String> task29 = names.stream().filter( n -> n != null && !n.isEmpty()).toList();

    /*Partition students into pass/fail groups based on grade*/
    Map<String,String> task30 = students.stream()
                    .collect(Collectors.toMap(
                            Student::getName,
                            n -> n.getGrade() >= 50 ? "pass" : "fail",
                            (a , b) -> a
                    ));

    Map<String, List<String>> task30_1 = students.stream()
            .collect(Collectors.groupingBy(
                    n -> n.getGrade() >= 50 ? "pass" : "fail",
                    Collectors.mapping(Student::getName, Collectors.toList())
            ));

}
