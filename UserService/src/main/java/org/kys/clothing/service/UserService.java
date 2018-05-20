package org.kys.clothing.service;

import org.kys.clothing.dataQuery.UserDataQuery;
import org.kys.clothing.user.UserBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDataQuery userDataQuery;

    public UserBean getUserInfo(String userCode){
        return userDataQuery.getUserInfo(userCode);
    }

    public boolean insertUserBean(UserBean userBean) {
        int returnStatus = userDataQuery.insertUserBean(userBean);
        return returnStatus==0?true:false;
    }
}
