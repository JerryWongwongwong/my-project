package com.jerry.myproject.util;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * CopyRight : <company domain>
 * Project :  zouwu-oms-framework
 * Comments : 对象trim字符串
 * JDK version : JDK1.8
 * Create Date : 2022-02-28 14:45
 *
 * @author : zyg
 * @version : 1.0
 * @since : 1.0
 */
public final class ObjectTrimUtils {

  private ObjectTrimUtils() {
  }

  /**
   * trim字符串属性
   * @param obj
   * @return
   */
  public static Object trimStringField(Object obj) {
    // 对象是空或者是基础类型, 则直接返回
    if (Objects.isNull(obj) || checkObjectType(obj)) {
      return obj;
    }
    // 对象是字符串类型, trim后返回
    if (obj instanceof String) {
      return StringUtils.trimWhitespace(String.valueOf(obj));
    }
    // 对象是Map对象，trim其value值后返回
    if (obj instanceof Map) {
      return trimMap((Map) obj);
    }
    // 对象是集合对象, 循环trim后返回
    if (obj instanceof Collection) {
      return trimCollection((Collection<Object>) obj);
    }
    // 对象是数组，则循环数组进行trim后返回
    if (obj.getClass().isArray()) {
      return trimArray((Object[]) obj);
    }
    // 按照对象进行trim后返回
    return trimObject(obj);
  }

  /**
   * 检查Object类型
   * @param clazz
   * @return
   */
  private static boolean checkObjectClass(Class<?> clazz) {
    boolean result = clazz.isPrimitive();
    result = result || clazz.isAnnotation();
    result = result || clazz.isEnum();
    result = result || clazz.isInterface();
    return result;
  }

  /**
   * 检查Object类型
   * @param obj
   * @return
   */
  private static boolean checkObjectType(Object obj) {
    boolean result = checkObjectClass(obj.getClass());
    result = result || obj instanceof Number;
    result = result || obj instanceof Character;
    result = result || obj instanceof Boolean;
    return result;
  }

  /**
   * trim Map的value值
   * @param map
   * @return
   */
  private static Object trimMap(Map map) {
    map.keySet().forEach(key -> map.put(key, trimStringField(map.get(key))));
    return map;
  }

  /**
   * 循环trim集合对象
   * @param collection
   * @return
   */
  private static Collection trimCollection(Collection<Object> collection) {
    List list = collection.stream().filter(Objects::nonNull).map(ObjectTrimUtils::trimStringField).collect(Collectors.toList());
    collection.clear();
    collection.addAll(list);
    return collection;
  }

  /**
   * 循环trim数组对象
   * @param array
   * @return
   */
  private static Object[] trimArray(Object[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = ObjectTrimUtils.trimStringField(array[i]);
    }
    return array;
  }

  /**
   * trim对象类型
   * @param obj
   * @return
   */
  private static Object trimObject(Object obj) {
    // 获取对象所有字段
    PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(obj.getClass());
    // 循环字段进行trim后赋值
    Arrays.stream(propertyDescriptors).forEach(property -> {
      try {
        // 调用trimStringField方法对对象属性进行深层次递归处理
        Method writeMethod = property.getWriteMethod();
        Method readMethod = property.getReadMethod();
        if (Objects.nonNull(writeMethod) && Objects.nonNull(readMethod) && !checkObjectClass(readMethod.getReturnType())) {
          writeMethod.invoke(obj, trimStringField(readMethod.invoke(obj)));
        }
      } catch (Exception e) {

      }
    });
    return obj;
  }

  public static void main(String[] args) {
    String a = "10000";
    FileReq fileReq = new FileReq();
    fileReq.setFileBytes(a.getBytes());
//    fileReq.setPathType(1);
//    fileReq.setFileName("11221");


    trimObject(fileReq);
  }
}
