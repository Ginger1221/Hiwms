package com.example.controller;

import com.example.domain.Users;
import com.example.domain.UsersInfo;
import com.example.service.UsersInfoService;
import com.example.service.UsersService;
import com.example.utils.EncryptUtil;
import com.example.utils.idGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ginger
 */
@Slf4j
//添加到IOC容器
@RestController
//设置路径
@RequestMapping("/usersInfo")
//解决跨域问题
@CrossOrigin

public class UsersInfoController {
    @Autowired
    private UsersInfoService usersInfoService;


    /**
     * 获取所有用户信息
     *
     * @return list
     */
    @GetMapping
    public List<UsersInfo> getAll() {
        System.out.println(usersInfoService.list());
        return usersInfoService.list();
    }

    /**
     * 根据id获取用户信息
     *
     * @param id id
     * @return info
     */
    @GetMapping("/{id}")
    public UsersInfo getById(@PathVariable long id) {
        return usersInfoService.getById(id);
    }


    /**
     * save user info
     * @param usersInfo info
     * @param userId id
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveUsersInfo(@RequestBody UsersInfo usersInfo, @RequestParam Integer userId) {
        try {

            long timeMillis = System.currentTimeMillis();
            usersInfo.setUserAltTime(timeMillis);
            usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUserAltTime()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersInfoService.save(usersInfo);
    }

    /**
     * 更新用户信息
     *
     * @param usersInfo info
     * @return if success
     */
    @PutMapping
    public boolean updateUsersInfo(@RequestParam Integer userId, @RequestParam Long usersInfoAltTime, @RequestBody UsersInfo usersInfo) {
        //得到UserInfoId
        usersInfo.setUserAltTime(usersInfoAltTime);
        usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUserAltTime()));

        return usersInfoService.updateById(usersInfo);
    }

    /**
     * 删除用户信息
     *
     * @param userId id
     * @return if success
     */
    @DeleteMapping()
    public boolean deleteUserInfo(@RequestParam Integer userId) {

        long id = userId;
        List<UsersInfo> usersInfoList = usersInfoService.list();
        for (UsersInfo value : usersInfoList
        ) {
            if (value.getUsersInfoId() == idGenerator.UserInfoIDGenerator(userId, value.getUserAltTime())) {
                id = value.getUsersInfoId();
            }
        }
        return usersInfoService.removeById(id);
    }


    /**
     * @param userId    id
     * @param usersInfo info
     * @return if success
     */
    @PostMapping("/init")
    public boolean intiUserInfo(@RequestParam Integer userId, @RequestBody UsersInfo usersInfo) {
        long timeMills = System.currentTimeMillis();
        usersInfo.setUserAltTime(timeMills);
        usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUserAltTime()));
        return usersInfoService.save(usersInfo);
    }

}
