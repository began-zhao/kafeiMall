package com.kafeimall.member.httpapi;

import com.kafeimall.common.auth.UserDto;
import com.kafeimall.common.result.Result;
import com.kafeimall.member.application.MemberApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author: zzg
 * @date: 9/27/22
 * @Description: zzg
 */
@RestController
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class MemberController {

    @Autowired
    MemberApplicationService memberService;

    @ApiOperation("会员登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam String username,
                        @RequestParam String password) {
        return memberService.login(username, password);
    }

    @ApiOperation("会员注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode) {
        memberService.register(username, password, telephone, authCode);
        return Result.success(null,"注册成功");
    }

    @GetMapping(value = "/loadByUsername")
    public UserDto loadByUsername(String username){
        UserDto userDto = new UserDto();
        userDto.setUsername("admin");
        userDto.setClientId("portal-app");
        userDto.setId(1L);
        userDto.setStatus(1);
        userDto.setRoles(new ArrayList<>(1));
        userDto.setPassword("$2a$10$wk6OV7P/DITS2ZX9GjRdX..itNer3vq11CkPXduwYN37G28WqcEMO");
        return userDto;
    }
}
