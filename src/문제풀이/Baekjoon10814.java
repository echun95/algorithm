package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Baekjoon10814 {
    static class Person{
        int age;
        String name;
        int created;

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public int getCreated() {
            return created;
        }

        public Person(int age, String name, int created) {
            this.age = age;
            this.name = name;
            this.created = created;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Person person = new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i);
            list.add(person);
        }
            list.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getCreated));
        for (Person person : list) {
            System.out.println(person.getAge() + " " + person.getName());
        }

    }
}
