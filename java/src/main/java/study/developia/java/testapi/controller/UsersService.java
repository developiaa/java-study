package study.developia.java.testapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.developia.java.testapi.service.OrdersService;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final OrdersService ordersService;

    public int getNumberOfItemsBought(String username) {
        return ordersService.itemsBought(username).size();
    }
}
