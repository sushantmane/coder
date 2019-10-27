#### Converting Array to List and vice versa
```Java
void intArrayToList() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    for (int i : list) {
        System.out.print(i + " ");
    }
}

void strArrayToList() {
    String[] arr = {"a", "b", "c", "d", "e"};
    List<String> list = Arrays.stream(arr).collect(Collectors.toList());
    for (String str : list) {
        System.out.print(str + " ");
    }
}

void strListToArray() {
    List<String> list = Arrays.asList( "a", "b", "c", "d", "e");
    String[] arr = list.toArray(new String[list.size()]);
    Arrays.stream(arr).forEach(System.out::print);
}

void intListToArray() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
    Arrays.stream(arr).forEach(System.out::print);
}

```
