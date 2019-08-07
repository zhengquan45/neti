package com.zhq.neti.common;

import cn.hutool.core.map.MapUtil;
import com.zhq.neti.common.enums.CodeEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EnumConverterFactory implements ConverterFactory<String, CodeEnum> {

    private static final Map<Class, Converter> converterMap = MapUtil.newHashMap();

    @Override
    public <T extends CodeEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter converter = converterMap.get(targetType);
        if(converter==null){
            converter = new EnumConverter(targetType);
            converterMap.put(targetType,converter);
        }
        return converter;
    }

    class EnumConverter <T extends CodeEnum> implements Converter<String,T>{

        private Map<Integer,T>enumMap = MapUtil.newHashMap();

        public EnumConverter(Class<T> enumType) {
            T[] enums = enumType.getEnumConstants();
            for(T e : enums) {
                enumMap.put(e.getCode(), e);
            }
        }

        @Override
        public T convert(String code) {
            T t = enumMap.get(Integer.parseInt(code));
            if(t==null){
                throw new IllegalArgumentException("枚举类转换错误");
            }
            return t;
        }
    }
}
