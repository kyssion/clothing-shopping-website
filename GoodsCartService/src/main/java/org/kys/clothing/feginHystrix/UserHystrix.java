package org.kys.clothing.feginHystrix;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.fegin.UserFegin;
import org.kys.clothing.user.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserHystrix implements UserFegin {
    private static final Logger logger = LoggerFactory.getLogger(UserHystrix.class);

    @Override
    public UserBean getUserInfo(String userCode) {
        return null;
    }
}
