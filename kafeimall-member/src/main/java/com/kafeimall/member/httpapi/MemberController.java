package com.kafeimall.member.httpapi;

import com.kafeimall.common.result.Result;
import com.kafeimall.member.application.MemberApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zzg
 * @date: 9/27/22
 * @Description: zzg
 */
@RestController
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("member/sso")
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
}
