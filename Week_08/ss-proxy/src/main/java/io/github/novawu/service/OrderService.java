package io.github.novawu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.novawu.domain.Order;
import io.github.novawu.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
}
