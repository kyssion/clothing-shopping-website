package org.kys.util;

import org.kys.util.datePackaging.ReturnListDataPackaging;

import java.util.List;

public class PageUtil {
    public static int EACH_PAGE_SIZE=20;//每页数量
    public static ReturnListDataPackaging getReturnListPackaging(List list){
        return new ReturnListDataPackaging(list);
    }
}
