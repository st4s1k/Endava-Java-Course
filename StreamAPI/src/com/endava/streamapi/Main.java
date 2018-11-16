package com.endava.streamapi;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        User u0 = new User("UserZero" , Role.JUNIOR   , "0@gmail.com"  );
        User u1 = new User("UserOne"  , Role.MIDDLE   , "1@yahoo.com"   );
        User u2 = new User("UserTwo"  , Role.SENIOR   , "2@mail.ru"     );
        User u3 = new User("UserThree", Role.LEAD     , "3@msn.com"   );
        User u4 = new User("UserFour" , Role.ARCHITECT, "4@outlook.com");

        u0.setIsActive(false);
        u1.setBalance(13d);
        u2.setBalance(252d);
        u3.setIsActive(false);
        u4.setBalance(99.14d);

        System.out.println("\n\t*) Get sorted list of distinct users");

        System.out.println("\n\tUsers sorted by role:\n");
        List<User> usersSortedByRole = List.of(u0, u2, u4).stream()
                .sorted(Comparator.comparing(User::getRole))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\n\tUsers sorted by isActive:\n");
        List<User> usersSortedByIsActive = List.of(u1, u1, u3, u4).stream()
                .sorted(Comparator.comparing(User::getIsActive))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\n\tUsers sorted by registrationDate:\n");
        List<User> usersSortedByRegistrationDate = List.of(u0, u1, u3, u4, u2, u4).stream()
                .sorted(Comparator.comparing(User::getRegistrationDate))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\n\tUsers sorted by balance:\n");
        List<User> usersSortedByBalance = List.of(u1, u2, u2, u4).stream()
                .sorted(Comparator.comparing(User::getBalance))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\n\tUsers sorted by name:\n");
        List<User> usersSortedByName = List.of(u0, u1, u2, u4).stream()
                .sorted(Comparator.comparing(User::getName))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\n\tUsers sorted by email:\n");
        List<User> usersSortedByEmail = List.of(u3, u1, u2, u4).stream()
                .sorted(Comparator.comparing(User::getEmail))
                .peek(System.out::println)
                .collect(Collectors.toList());

        List<User> userList = List.of(u0, u1, u2, u3, u4);

        System.out.println("\n\t*) Get min, max, average balance");

        System.out.println("\n\tUsers' balance:\n");

        var usersMinBalance = userList.stream()
                .map(User::getBalance)
                .peek(System.out::println)
                .mapToDouble(d -> d).min()
                .orElseThrow(NoSuchElementException::new);

        var usersMaxBalance = userList.stream()
                .map(User::getBalance)
                .mapToDouble(d -> d).max()
                .orElseThrow(NoSuchElementException::new);

        var usersAvgBalance = userList.stream()
                .map(User::getBalance)
                .mapToDouble(d -> d).average()
                .orElseThrow(NoSuchElementException::new);

        System.out.println("\n\tUsers' min balance: " + usersMinBalance);
        System.out.println("\n\tUsers' max balance: " + usersMaxBalance);
        System.out.println("\n\tUsers' average balance: " + usersAvgBalance);

        System.out.println("\n\t*) Partition users by active and locked accounts");

        Map<Boolean, List<User>> groups1 = userList.stream()
                .collect(Collectors.partitioningBy(User::getIsActive));
        List<List<User>> subSets1 = new ArrayList<>(groups1.values());

        System.out.println("\n\tLocked:\n");
        for (User u: subSets1.get(0)) {
            System.out.println(u);
        }

        System.out.println("\n\tActive:\n");
        for (User u: subSets1.get(1)) {
            System.out.println(u);
        }

        System.out.println("\n\t*) Get list of emails");

        System.out.println("\n\tList of emails:\n");

        List<String> usersListOfEmails = userList
                .stream()
                .map(User::getEmail)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\n\t*) Group users by registration date");

        Map<LocalDate, List<User>> groups2 = userList.stream()
                .collect(Collectors.groupingBy(User::getRegistrationDate));

        List<List<User>> subSets2 = new ArrayList<>(groups2.values());

        for (List<User> ul: subSets2){
            System.out.println("\n\t" +
                    ul.get(0).getRegistrationDate() + ":\n");
            for (User u: ul) {
                System.out.println(u);
            }
        }

        System.out.println("\n\t*) Group users by their roles");

        Map<Role, List<User>> groups3 = List.of(u0,
                                                u1, u1,
                                                u2, u2, u2,
                                                u3, u3, u3, u3,
                                                u4, u4, u4, u4, u4).stream()
                .collect(Collectors.groupingBy(User::getRole));

        List<List<User>> subSets3 = new ArrayList<>(groups3.values()).stream()
                .sorted(Comparator.comparing(ul -> ul.get(0).getRole()))
                .collect(Collectors.toList());

        for (List<User> ul: subSets3){
            System.out.println("\n\t" +
                    ul.get(0).getRole() + ":\n");
            for (User user: ul) {
                System.out.println(user);
            }
        }

        System.out.println("\n\t*) Get set from list");

        System.out.println("\n\tSet of users:\n");

        Set<User> setOfUsers = userList
                .stream()
                .peek(System.out::println)
                .collect(Collectors.toSet());

        long numberOfNotActiveUsers = userList.stream().filter(u -> !u.getIsActive()).count();

        System.out.println("\n\t*) Number of not active users: " + numberOfNotActiveUsers);

        System.out.println("\n\t*) Get first user with balance > 10000, and what if there is none such?\n");

        u4.setBalance(25000d);

        User userWithBalanceOver10000 = List.of(u0, u1, u2, u3, u4)
                .stream()
                .filter(u -> u.getBalance() > 10000)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        System.out.println(userWithBalanceOver10000);

        u4.setBalance(100d);

        try {

            User userWithNoBalanceOver10000 = List.of(u0, u1, u2, u3, u4)
                    .stream()
                    .filter(u -> u.getBalance() > 10000)
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);

            System.out.println(userWithNoBalanceOver10000);

        } catch (NoSuchElementException e) {
            System.out.println("No user with balance over 1000 found!");
        }

        System.out.println("\n\t*) Reduce all users names into 1 coma separated string");

        System.out.println("\n\tUsers' names:\n");

        String usersNames = userList
                .stream()
                .map(User::getName)
                .reduce("",
                        (result, currentName) -> {
                            StringBuilder sb = new StringBuilder();
                            sb.append(result);
                            if (result.length() > 0)
                                sb.append(",");
                            sb.append(currentName);
                            return sb.toString();
                        }
                );

        System.out.println(usersNames);

        System.out.println("\n\tCreate 2 lists of ints and chars, " +
                "and using stream api get cartesian product of those 2 lists.");

        List<Integer> ints = List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

        List<Character> chars = List.of('H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!');

        System.out.println("\n\tList 1 (of ints):\t" + ints);
        System.out.println("\n\tList 2 (of chars):\t" + chars + "\n");

        List<List<Pair<Integer, Character>>> cartesian = ints
                .stream()
                .map(i -> chars
                        .stream()
                        .map(c ->  Pair.createPair(i, c))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());


        for (List<Pair<Integer, Character>> lp: cartesian) {
            for (Pair<Integer, Character> p: lp) {
                System.out.print(p + " ");
            }
            System.out.println();
        }

        System.out.println("\n\tCalculate factorial using IntStream.");

        var number = 3;

        var factorial = IntStream.rangeClosed(1, number).reduce(1, (x, y) -> x*y);

        System.out.println("\n\tFactorial for " + number + " is: " + factorial + "\n");

    }
}

