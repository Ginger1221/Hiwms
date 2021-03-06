package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.config.StockInEvent;
import com.example.dao.StockInDao;
import com.example.domain.StockIn;
import com.example.service.StockInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/stockIn")
/**
 * 入库订单生成逻辑
 * 前端传来物品名称和数量
 */
public class StockInController {

    @Autowired
    private StockInService stockInService;

    @Autowired
    private StockInDao stockInDao;

    @Autowired
    private WebApplicationContext webapplicationcontext;

    public StockInController(OrdersController ordersController) {

        this.ordersController = ordersController;
    }

    OrdersController ordersController;


    /**
     * 获取全部入库信息
     *
     * @return list
     */
    @GetMapping
    public List<StockIn> getAll() {
        System.out.println(stockInService.list());
        return stockInService.list();
    }

    /**
     * @param stockIn 对象
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveStockIn(@RequestBody StockIn stockIn, HttpServletRequest request) {
        //type = 1 入库
        stockIn.setOrderId(ordersController.initOrders(1, request));
        boolean ifSuccess = stockInService.save(stockIn);
        Integer id = stockIn.getOrderId();
        StockInEvent stockInEvent=new StockInEvent("stockIn:",stockIn,"新的入库申请", id);
        webapplicationcontext.publishEvent(stockInEvent);
        return ifSuccess;
    }

    /**
     * 根据订单ID得到入库货品信息
     *
     * @param orderId id
     * @return 入库
     */
    @GetMapping("/getByOrderId")
    public List<StockIn> getByOrderId(@RequestParam Integer orderId) {

        QueryWrapper<StockIn> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id", orderId);
        return stockInDao.selectList(wrapper);
    }


    /**
     * 删除入库申请记录
     *
     * @param id id
     * @return if success
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {

        return stockInService.removeById(id);

    }


}
