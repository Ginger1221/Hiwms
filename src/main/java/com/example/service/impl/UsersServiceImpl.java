package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UsersDao;
import com.example.domain.Users;
import com.example.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersDao,Users> implements UsersService {

//    @Override
//    public List<Users> findUserByusername(String username) {
//        List<Users> checkedUsers;
//
//        for (Users name : Users.list()
//             ) {
//            if(name.getUserName().equals(username))
//            checkedUsers = name;
//        }
//        return checkedUsers;
//    }
}
