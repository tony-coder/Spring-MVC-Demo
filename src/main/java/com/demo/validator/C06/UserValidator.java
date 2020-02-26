package com.demo.validator.C06;

import com.demo.domain.C06.ValidatorTest.User;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * UserValidator实习了Spring的Validator接口，其可以对User对象进行数据校验，并分别使用ValidationUtils的rejectIfEmpty方法和
 * Errors的rejectValue方法对User进行了数据校验。@Repository("userValidator")注解将该对象注释为Spring容器中的一个Bean，名字为"userValidator"。
 */

// 实现Spring的Validator接口
@Repository("userValidator")
public class UserValidator implements Validator {
    // 该校验器能够对clazz类型的对象进行校验。
    @Override
    public boolean supports(Class<?> aClass) {
        // User指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口。
        return User.class.isAssignableFrom(aClass);
    }

    // 对目标target进行校验，并将校验错误记录在errors当中
    @Override
    public void validate(Object o, Errors errors) {
        /**
         使用ValidationUtils中的一个静态方法rejectIfEmpty()来对loginname属性进行校验，
         假若'loginname'属性是 null 或者空字符串的话，就拒绝验证通过 。
         */
        ValidationUtils.rejectIfEmpty(errors, "my_loginname", null, "登录名不能为空");
        ValidationUtils.rejectIfEmpty(errors, "my_password", null, "密码不能为空");
        User user = (User) o;
        if (user.getMy_loginname().length() > 10) {
            // 使用Errors的rejectValue方法验证
            errors.rejectValue("my_loginname", null, "用户名不能超过10个字符");
        }
        if (user.getMy_password() != null && !user.getMy_password().equals("") && user.getMy_password().length() < 6) {
            errors.rejectValue("my_password", null, "密码不能小于6位");
        }
    }
}
