package com.springboot.endereco.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    public static Boolean isNullOrEmptyOrBlank(String str) {
        return str == null || StringUtils.isEmpty(str) || StringUtils.isBlank(str);
    }
}
