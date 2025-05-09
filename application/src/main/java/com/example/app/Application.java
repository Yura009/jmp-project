package com.example.app;

import com.example.dto.BankCard;
import com.example.dto.Subscription;
import com.example.dto.User;
import com.example.service.Service;
import com.example.service.impl.ServiceImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Service service = new ServiceImpl();

        User user = new User("John", "Doe", LocalDate.of(2000, 1, 1));
        service.addUser(user);

        User user2 = new User("Sara", "Bou", LocalDate.of(2010, 1, 1));
        service.addUser(user2);

        BankCard card = new BankCard("1234567890", user);
        service.subscribe(card);

        BankCard card2 = new BankCard("0123456789", user2);
        service.subscribe(card2);

        System.out.println(service.getSubscriptionByBankCardNumber("1234567890").isPresent());

        List<User> allUsers = service.getAllUsers();
        allUsers.forEach(u -> System.out.println("User name: " + u.getName() + " | User Surname: "
                + u.getSurName() + " | User birthday: " + u.getBirthDay()));

        System.out.println("Average users age: " + service.getAverageUserAge());
        System.out.println("Is payable user? " + Service.isPayableUser(user));
        System.out.println("Is payable user? " + Service.isPayableUser(user2));

        var unmodifiableUsers = allUsers.stream()
                .filter(u -> u.getName().toLowerCase().startsWith("j"))
                .collect(Collectors.toUnmodifiableList());
        unmodifiableUsers.forEach(u -> System.out.println(u.getSurName()));

        LocalDate cutoffDate = LocalDate.of(2020, 1, 1);
        List<Subscription> subscriptions =
                service.getAllSubscriptionsByCondition(s -> s.getStartDate().isAfter(cutoffDate));

        subscriptions.forEach(s -> System.out.println("Filtered card numbers: " + s.getBankCardNumber()));

        ServiceLoader<Service> serviceLoader = ServiceLoader.load(Service.class);
        for (Service s : serviceLoader) {
            System.out.println("Loaded service: " + s.getClass().getName());
            s.getAllUsers().forEach(u -> System.out.println(u.getName()));
        }
    }
}
