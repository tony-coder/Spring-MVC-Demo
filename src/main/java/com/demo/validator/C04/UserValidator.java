package com.demo.validator.C04;

import com.demo.domain.C04.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * UserValidator 类实现org.springframework.validation.Validator 接口，完成验证的功能
 */

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // 验证username、sex和age是否为null
        ValidationUtils.rejectIfEmpty(errors, "username", null, "用户名不能为空");
        ValidationUtils.rejectIfEmpty(errors, "sex", null, "性别不能为空");
        ValidationUtils.rejectIfEmpty(errors, "age", null, "年龄不能为空");

    }
}
