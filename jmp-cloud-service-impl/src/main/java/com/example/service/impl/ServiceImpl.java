package com.example.service.impl;

import com.example.dto.BankCard;
import com.example.dto.Subscription;
import com.example.dto.User;
import com.example.exception.SubscriptionNotFoundException;
import com.example.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServiceImpl implements Service {

    private List<BankCard> bankCards = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Subscription> subscriptions = new ArrayList<>();

    @Override
    public void subscribe(BankCard card) {
        bankCards.add(card);

        Subscription subscription = new Subscription();
        subscription.setBankCardNumber(card.getNumber());
        subscription.setStartDate(LocalDate.now());
        subscriptions.add(subscription);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        return Optional.ofNullable(subscriptions.stream()
                .filter(sub -> sub.getBankCardNumber().equals(cardNumber))
                .findFirst()
                .orElseThrow(() -> new SubscriptionNotFoundException("Subscription not found!")));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addBankCard(BankCard bankCard) {
        bankCards.add(bankCard);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
        return subscriptions.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
}
