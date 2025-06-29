package com.zwh.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.mapper.MenuMapper;
import com.zwh.yyzx.mapper.RolemenuMapper;
import com.zwh.yyzx.mapper.UserMapper;
import com.zwh.yyzx.pojo.Menu;
import com.zwh.yyzx.pojo.User;
import com.zwh.yyzx.service.UserService;
import com.zwh.yyzx.utils.ResultVo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private RolemenuMapper rolemenuMapper;
    @Resource
    private MenuMapper menuMapper;

    public ResultVo<User> login(String username, String password)throws Exception{
        QueryWrapper qw=new QueryWrapper();
        qw.eq("username",username);
        qw.eq("password",password);
        User user=getOne(qw);
        System.out.println(user);
        if(user!=null){
            if(user.getIsDeleted()==0) {

                QueryWrapper listRoleQw=new QueryWrapper<>();
                listRoleQw.eq("role_id",user.getRoleId());
                listRoleQw.select("menu");
                List<Integer> menuIds=rolemenuMapper.selectObjs(listRoleQw);

                List<Menu> menus=menuMapper.selectBatchIds(menuIds);

                for(Menu menu:menus){
                    QueryWrapper listMenuQw=new QueryWrapper<>();
                    listMenuQw.eq("parent_id",menu.getId());
                    menu.setChildren(menuMapper.selectList(listMenuQw));
                }
                user.setMenuList(menus);
                HashMap<String,Object> map=new HashMap<>();

                JwtBuilder builder = Jwts.builder();
                String token = builder.setSubject(username)
                        .setIssuedAt(new Date())
                        .setId(user.getId().toString())
                        .setClaims(map)
                        .setExpiration(new Date(System.currentTimeMillis() +   24 * 60 * 60 * 1000))
                        .signWith(SignatureAlgorithm.HS256,"hzw123456")
                        .compact();
                return ResultVo.ok(user,token);
            }
            return ResultVo.fail("无权限，请联系管理员");
        }
        return ResultVo.fail("账号密码错误");
    }

}
