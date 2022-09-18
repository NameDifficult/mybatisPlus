package org.fu.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fu.mybatisplus.mapper.UserMapper;
import org.fu.mybatisplus.pojo.User;
import org.fu.mybatisplus.service.api.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
