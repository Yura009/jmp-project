package com.example.bank;

import com.example.dto.BankCard;
import com.example.dto.BankCardType;
import com.example.dto.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType type);
}
