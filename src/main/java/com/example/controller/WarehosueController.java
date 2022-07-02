package com.example.controller;

import com.example.domain.Warehouse;
import com.example.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/warehouse")
public class WarehosueController {
    @Autowired
    private WarehouseService warehouseService;

    /**
     * 获取全部货品
     * @return
     */
    @GetMapping//访问方式
    public List<Warehouse> getAll() {
        //log.info("goods获取的数据，{}",goodsService.list());
        //System.out.println("used");
        return warehouseService.list();
    }

    /**
     * 根据id获取货物
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable int id) {
        return warehouseService.getById(id);
    }

    /**
     * 删除货物
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){

        return warehouseService.removeById(id);

    }

    /**
     * 保存用户
     * @param warehouse
     * @return
     */
    @PostMapping
    public boolean saveWarehouse(@RequestBody Warehouse warehouse){
        System.out.println("save!");
        return warehouseService.save(warehouse);
    }


    @PutMapping
    public boolean updateWarehouse(@RequestBody Warehouse warehouse){
        System.out.println(warehouse.getWarehouseName());
        return warehouseService.updateById(warehouse);
    }
}
