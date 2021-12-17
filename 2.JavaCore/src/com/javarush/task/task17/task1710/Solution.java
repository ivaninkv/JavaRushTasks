package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        if (args.length == 0) {
            printUsageAndExit();
        }

        switch (args[0]) {
            case "-c":
                create(args);
                break;
            case "-r":
                read(args);
                break;
            case "-u":
                update(args);
                break;
            case "-d":
                delete(args);
                break;
            default:
                printUsageAndExit();
        }

    }

    private static void create(String[] args) {
        String name = args[1];
        String sex = args[2];
        Date bd = null;
        try {
            bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Person person;
        if (sex.equals("м")) {
            person = Person.createMale(name, bd);
        } else {
            person = Person.createFemale(name, bd);
        }
        allPeople.add(person);
        System.out.println(allPeople.size() - 1);
    }

    private static void read(String[] args) {
        int id = Integer.parseInt(args[1]);
        Person person = allPeople.get(id);
        String bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)
                .format(person.getBirthDate());
        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
        System.out.println(person.getName() + " " + sex + " " + bd);
    }

    private static void update(String[] args) {
        int id = Integer.parseInt(args[1]);
        String name = args[2];
        String sex = args[3];
        Date bd = null;
        try {
            bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Person person = allPeople.get(id);
        person.setName(name);
        person.setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
        person.setBirthDate(bd);
    }

    private static void delete(String[] args) {
        int id = Integer.parseInt(args[1]);
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
    }

    private static void printUsageAndExit() {
        System.out.println("Usage of program:\n" +
                "-c name sex bd\n" +
                "-r id\n" +
                "-u id name sex bd\n" +
                "-d id");
        System.exit(0);
    }
}
