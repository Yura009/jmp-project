package com.example.bank.impl;

import com.example.bank.Bank;
import com.example.dto.*;

import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;

public class InvestmentBank implements Bank {
    private static final Map<BankCardType, BiFunction<String, User, BankCard>> cardConstructors = Map.of(
            BankCardType.CREDIT, CreditBankCard::new,
            BankCardType.DEBIT, DebitBankCard::new
    );

    @Override
    public BankCard createBankCard(User user, BankCardType type) {
        var cardNumber = "INVESTMENT-" + UUID.randomUUID();
        return cardConstructors.get(type).apply(cardNumber, user);
    }
}
