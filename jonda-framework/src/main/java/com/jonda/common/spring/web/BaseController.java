package com.jonda.common.spring.web;

import org.springframework.ui.Model;
import org.springside.modules.mapper.JsonMapper;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * Created by rejoady on 2014/7/24.
 */
public class BaseController {

    protected static final String FIELD_MESSAGE_KEY = "FIELD_MESSAGE_KEY";

    protected static final String ACTION_MESSAGE_KEY = "ACTION_MESSAGE_KEY";

    protected  <T> Map<String, String> validate(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violationSet = validator.validate(target);
        if (violationSet == null || violationSet.isEmpty()) {
            return null;
        }
        Map<String, String> result = new HashMap<String, String>();
        for (ConstraintViolation<T> entry : violationSet) {
            String key = entry.getPropertyPath().toString();
            String val = entry.getMessage();
            result.put(key,val);
        }
        return result;
    }

    protected <T> AjaxResult checkParam(T object) {
        Map<String, String> filedError = validate(object);
        if (filedError == null || filedError.isEmpty()) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : filedError.entrySet()) {
            sb.append(entry.getValue()).append("<br/>");
        }
        return new AjaxResult(StatusCodeEnum.ERROR, sb.toString());
    }

    /**
     * 添加字段消息
     *
     * @param model
     * @param fieldName
     * @param message
     */
    protected void addFieldMessage(Model model, String fieldName, String message)  {
        Map<String, String> messageMap;
        if (model.containsAttribute(FIELD_MESSAGE_KEY)) {
            messageMap = (Map<String, String>)model.asMap().get(ACTION_MESSAGE_KEY);
        } else {
            messageMap = new HashMap<String, String>();
        }
        messageMap.put(fieldName, message);
        model.addAttribute(FIELD_MESSAGE_KEY, messageMap);
    }

    /**
     * 添加页面信息
     *
     * @param model
     * @param message
     */
    protected void addActionMessage(Model model, String message) {
        List<String> messageList;
        if (model.containsAttribute(ACTION_MESSAGE_KEY)) {
            messageList = (List<String>)model.asMap().get(ACTION_MESSAGE_KEY);
        } else {
            messageList = new ArrayList<String>();
        }
        messageList.add(message);
        model.addAttribute(ACTION_MESSAGE_KEY, messageList);
    }

    protected Boolean hasMessages(Model model) {
        return hasActionMessages(model) || hasFieldMessages(model);
    }

    protected Boolean hasFieldMessages (Model model) {
        if (model.containsAttribute(FIELD_MESSAGE_KEY)) {
            Map<String, String> messageMap = (Map<String, String>)model.asMap().get(FIELD_MESSAGE_KEY);
            if (messageMap != null && !messageMap.isEmpty()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 判断是否有Action级别的信息
     *
     * @param model
     * @return
     */
    protected Boolean hasActionMessages(Model model) {
        if (model.containsAttribute(ACTION_MESSAGE_KEY)) {
            List<String> messageList = (List<String>)model.asMap().get(ACTION_MESSAGE_KEY);
            if (messageList != null && !messageList.isEmpty()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 返回json结果
     *
     * @param result
     * @return
     */
    protected String ajaxResult(AjaxResult result) {
        JsonMapper jsonMapper = new JsonMapper();
        return jsonMapper.toJson(result);
    }

}
