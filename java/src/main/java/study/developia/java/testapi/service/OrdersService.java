package study.developia.java.testapi.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface OrdersService {
    List<Integer> itemsBought(String username);
}
