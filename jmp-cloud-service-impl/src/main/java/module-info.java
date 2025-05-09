module jmp.cloud.service.impl {
    requires jmp.dto;
    requires transitive jmp.service.api;
    provides com.example.service.Service with com.example.service.impl.ServiceImpl;
    exports com.example.service.impl;
}