package com.lkc.shiro;

import com.lkc.model.UserEntity;
import com.lkc.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String userName=authenticationToken.getPrincipal().toString();

        //UserService userService = SpringBeanFactoryUtils.getBean("userService", UserService.class);
        UserEntity user=userService.selectUserByCode(userName);
        if (user==null){
            throw new UnknownAccountException();
        }

        ByteSource saltByte = ByteSource.Util.bytes(user.getSalt());

        SimpleAuthenticationInfo sai= new SimpleAuthenticationInfo(user,user.getPassword(),saltByte,this.getName());
        return sai;
    }
}
