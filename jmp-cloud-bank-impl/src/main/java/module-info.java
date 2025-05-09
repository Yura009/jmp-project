module jmp.cloud.bank.impl {
    requires jmp.bank.api;
    requires jmp.dto;
    provides com.example.bank.Bank with com.example.bank.impl;
    exports com.example.bank.impl;
}