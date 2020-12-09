package io.github.novawu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.novawu.domain.Order;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

    int insertBatchSomeColumn(List<Order> entityList);

}
