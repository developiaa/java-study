package study.developia.java.testapi.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{
    public List<Integer> itemsBought(String username){
        return new ArrayList<>();
    };
}
