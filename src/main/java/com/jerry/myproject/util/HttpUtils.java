//package com.jerry.myproject.util;
//
//import cn.hutool.core.collection.CollectionUtil;
//import com.google.common.collect.ImmutableMap;
//import com.google.common.collect.Lists;
//import com.wwl.zouwu.oms.framework.result.enums.ResultInfoEnums;
//import com.wwl.zouwu.oms.framework.result.exception.BusinessException;
//import com.wwl.zouwu.oms.framework.utils.common.ObjectMapperUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpStatus;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpPut;
//import org.apache.http.client.methods.HttpRequestBase;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.message.BasicHeader;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.springframework.util.Assert;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import java.io.File;
//import java.net.URISyntaxException;
//import java.nio.charset.Charset;
//import java.security.cert.X509Certificate;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Optional;
//
///**
// * CopyRight : <company domain>
// * Project :  zouwu-oms-wms-esb
// * Comments : http请求工具类
// * JDK version : JDK1.8
// * Create Date : 2022-03-14 17:25
// *
// * @author : zyg
// * @version : 1.0
// * @since : 1.0
// */
//@Slf4j
//public class HttpUtils {
//
//  private static final String CHARSET = "utf-8";
//  private static final int CONNECTION_TIMEOUT = 10000;
//  private static final int SOCKET_TIMEOUT = 10000;
//  private static final int CONNECTION_REQUEST_TIMEOUT = 10000;
//  private static final int MAX_CONNECTION_PER_HOST = 20;
//  private static final int MAX_TOTAL_CONNECTIONS = 100;
//  private static final String SSL_PROTOCOL = "SSL";
//  private static final String CONTENT_TYPE_HEADER = "Content-Type";
//  private static final String ACCEPT_HEADER = "Accept";
//  private static String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded";
//  private static String JSON_CONTENT_TYPE = "application/json";
//  private static String MULTIPART_CONTENT_TYPE = "multipart/form-data";
//  private static final ImmutableMap<String, String> DEFAULT_HEADER;
//  private static final CloseableHttpClient CLIENT;
//
//  private HttpUtils() {
//  }
//
//  static {
//    //创建自定义的httpclient对象
//    CLIENT = initClient();
//    // 初始化默认请求头
//    DEFAULT_HEADER = initDefaultHeader();
//  }
//
//  /**
//   * post请求
//   *
//   * @param url          请求路径
//   * @param urlParams    公共参数
//   * @param body         请求体
//   * @param headerParams 请求头
//   * @return
//   */
//  public static String post(String url, Map<String, Object> urlParams, Map<String, String> headerParams, String body) {
//    try {
//      URIBuilder uriBuilder = new URIBuilder(url);
//      uriBuilder.addParameters(toNameValuePair(urlParams));
//      HttpPost post = new HttpPost(uriBuilder.build());
//      setDefaultHeader(post);
//      setHeader(post, headerParams);
//      setBody(post, body);
//      return execute(post);
//    } catch (URISyntaxException e) {
//      throw new BusinessException(ResultInfoEnums.URL_SYNTAX_ERROR);
//    }
//  }
//
//
//  /**
//   * post请求
//   *
//   * @param url          请求路径
//   * @param body         请求体
//   * @param headerParams 请求头
//   * @return
//   */
//  public static String post(String url, Map<String, String> headerParams, String body) {
//    HttpPost post = new HttpPost(url);
//    setDefaultHeader(post);
//    setHeader(post, headerParams);
//    setBody(post, body);
//    return execute(post);
//  }
//
//  /**
//   * post请求
//   *
//   * @param url          请求路径
//   * @param bodyParams   请求体
//   * @param headerParams 请求头
//   * @return
//   */
//  public static String post(String url, Map<String, Object> bodyParams, Map<String, String> headerParams) {
//    HttpPost post = new HttpPost(url);
//    setDefaultHeader(post);
//    setHeader(post, headerParams);
//    setBodyParams(post, bodyParams);
//    return execute(post);
//  }
//
//  /**
//   * post请求
//   *
//   * @param url        请求路径
//   * @param bodyParams 请求体
//   * @return
//   * @throws Exception
//   */
//  public static String post(String url, Map<String, Object> bodyParams) {
//    return post(url, bodyParams, null);
//  }
//
//  /**
//   * post请求
//   *
//   * @param url          请求路径
//   * @param file         上传文件
//   * @param headerParams 请求头
//   * @return
//   * @throws Exception
//   */
//  public static String uploadByPost(String url, File file, Map<String, String> headerParams) {
//    HttpPost post = new HttpPost(url);
//    setHeader(post, headerParams);
//    String boundary = String.format("--------------%s%s", System.currentTimeMillis(), Double.valueOf(Math.random() * 100).intValue());
//    String contentType = String.format("%s; boundary=%s", MULTIPART_CONTENT_TYPE, boundary);
//    setHeader(post, ImmutableMap.of(CONTENT_TYPE_HEADER, contentType, ACCEPT_HEADER, JSON_CONTENT_TYPE));
//
//    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//    //字符编码
//    builder.setCharset(Charset.forName(CHARSET));
//    //模拟浏览器
//    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//    builder.setContentType(ContentType.MULTIPART_FORM_DATA);
//    //boundary
//    builder.setBoundary(boundary);
//    //multipart/form-data
//    builder.addPart("file", new FileBody(file, ContentType.DEFAULT_BINARY));
//    post.setEntity(builder.build());
//    return execute(post);
//  }
//
//  /**
//   * put请求
//   *
//   * @param url          请求路径
//   * @param bodyParams   请求体
//   * @param headerParams 请求头
//   * @return
//   */
//  public static String put(String url, Map<String, Object> bodyParams, Map<String, String> headerParams) {
//    HttpPut put = new HttpPut(url);
//    setDefaultHeader(put);
//    setHeader(put, headerParams);
//    setBodyParams(put, bodyParams);
//    return execute(put);
//  }
//
//  /**
//   * put请求
//   *
//   * @param url        请求路径
//   * @param bodyParams 请求体
//   * @return
//   * @throws Exception
//   */
//  public static String put(String url, Map<String, Object> bodyParams) {
//    return put(url, bodyParams, null);
//  }
//
//  /**
//   * get请求
//   *
//   * @param url          路径
//   * @param urlParams    请求参数
//   * @param headerParams 请求头
//   * @return
//   */
//  public static String get(String url, Map<String, Object> urlParams, Map<String, String> headerParams) {
//    try {
//      URIBuilder uriBuilder = new URIBuilder(url);
//      uriBuilder.addParameters(toNameValuePair(urlParams));
//      HttpGet get = new HttpGet(uriBuilder.build());
//      setDefaultHeader(get);
//      setHeader(get, headerParams);
//      return execute(get);
//    } catch (URISyntaxException e) {
//      throw new BusinessException(ResultInfoEnums.URL_SYNTAX_ERROR);
//    }
//  }
//
//  /**
//   * get请求
//   *
//   * @param url          请求路径
//   * @param headerParams 请求头
//   * @return
//   */
//  public static String get(String url, Map<String, String> headerParams) {
//    return get(url, null, headerParams);
//  }
//
//  /**
//   * 将url参数转换为拼接的字符串
//   *
//   * @param urlParams
//   * @return
//   */
//  public static String toQueryParams(Map<String, Object> urlParams) {
//    return CollectionUtil.isEmpty(urlParams) ? "" : URLEncodedUtils.format(toNameValuePair(urlParams), CHARSET);
//  }
//
//  /**
//   * 将url参数转换为NameValuePair集合
//   *
//   * @param urlParams
//   * @return
//   */
//  private static List<NameValuePair> toNameValuePair(Map<String, Object> urlParams) {
//    List<NameValuePair> params = Lists.newArrayList();
//    if (Objects.nonNull(urlParams)) {
//      urlParams.forEach((key, value) -> {
//        if (Objects.nonNull(value)) {
//          params.add(new BasicNameValuePair(key, String.valueOf(value)));
//        }
//      });
//    }
//    return params;
//  }
//
//  /**
//   * 设置默认请求头
//   *
//   * @param request 当前request
//   */
//  private static void setDefaultHeader(HttpRequestBase request) {
//    setHeader(request, DEFAULT_HEADER);
//  }
//
//  /**
//   * 设置请求头
//   *
//   * @param request      当前request
//   * @param headerParams 请求头
//   */
//  private static void setHeader(HttpRequestBase request, Map<String, String> headerParams) {
//    Assert.isTrue(Objects.nonNull(request), "httpRequest is required");
//    if (Objects.nonNull(headerParams)) {
//      headerParams.forEach((key, value) -> {
//        BasicHeader header = new BasicHeader(key, value);
//        request.setHeader(header);
//      });
//    }
//  }
//
//  /**
//   * 设置请求体
//   *
//   * @param request    当前request
//   * @param bodyParams 请求体
//   */
//  private static void setBodyParams(HttpEntityEnclosingRequestBase request, Map<String, Object> bodyParams) {
//    Assert.isTrue(Objects.nonNull(request), "httpRequest is required");
//    if (Objects.nonNull(bodyParams)) {
//      String s = ObjectMapperUtil.writeValueAsString(bodyParams);
//      HttpEntity entity = new StringEntity(s, CHARSET);
//      request.setEntity(entity);
//    }
//  }
//
//  /**
//   * 设置请求体
//   *
//   * @param request 当前request
//   * @param body    请求体
//   */
//  private static void setBody(HttpEntityEnclosingRequestBase request, String body) {
//    Assert.isTrue(Objects.nonNull(request), "httpRequest is required");
//    if (Objects.nonNull(body)) {
//      HttpEntity entity = new StringEntity(body, CHARSET);
//      request.setEntity(entity);
//    }
//  }
//
//  /**
//   * 执行http请求，并返回结果
//   *
//   * @param request
//   * @return
//   */
//  private static String execute(HttpUriRequest request) {
//    try (CloseableHttpResponse response = CLIENT.execute(request)) {
//      String result = getHttpResponse(response);
//      int statusCode = response.getStatusLine().getStatusCode();
//      if (Objects.equals(statusCode, HttpStatus.SC_OK) || Objects.equals(statusCode, HttpStatus.SC_CONFLICT) ||
//        Objects.equals(statusCode, HttpStatus.SC_CREATED) || Objects.equals(statusCode, HttpStatus.SC_NOT_FOUND)) {
//        return result;
//      }
//      log.error("{}请求失败,响应状态:{},返回结果:{}", request.getURI(), statusCode, result);
//      throw new BusinessException(ResultInfoEnums.HTTP_STATUS_CODE_ERROR);
//    } catch (BusinessException e) {
//      throw e;
//    } catch (Exception e) {
//      log.error("{}请求异常", request.getURI(), e);
////      throw new BusinessException(ResultInfoEnums.HTTP_EXECUTE_ERROR);
//    }
//  }
//
//  /**
//   * 转化http响应结果
//   *
//   * @param response
//   * @return
//   */
//  private static String getHttpResponse(CloseableHttpResponse response) {
//    HttpEntity httpEntity = response.getEntity();
//    if (Objects.isNull(httpEntity)) {
//      return null;
//    }
//    try {
//      return EntityUtils.toString(httpEntity, CHARSET);
//    } catch (Exception e) {
//
////      throw new BusinessException(ResultInfoEnums.PARSE_RESPONSE_ERROR);
//    }
//  }
//
//  /**
//   * 初始化httpClient
//   *
//   * @return
//   */
//  private static CloseableHttpClient initClient() {
//    // 设置协议http和https对应的处理socket链接工厂的对象
//    RegistryBuilder<ConnectionSocketFactory> socketFactoryBuilder = RegistryBuilder.create();
//    socketFactoryBuilder.register("http", PlainConnectionSocketFactory.INSTANCE);
//    // 设置协议http和https对应的处理socket链接工厂的对象
//    Optional.ofNullable(createIgnoreVerifySSL())
//      .ifPresent(sslContext -> socketFactoryBuilder.register("https",
//        new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE)));
//    // 设置链接池
//    PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryBuilder.build());
//    connManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
//    connManager.setDefaultMaxPerRoute(MAX_CONNECTION_PER_HOST);
//    //创建自定义的httpclient对象
//    return HttpClients.custom().setConnectionManager(connManager)
//      .setDefaultRequestConfig(RequestConfig.custom().setSocketTimeout(CONNECTION_TIMEOUT)
//        .setConnectTimeout(SOCKET_TIMEOUT).setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT).build()
//      ).disableAutomaticRetries().build();
//  }
//
//  /**
//   * 初始化默认请求头
//   *
//   * @return
//   */
//  private static ImmutableMap<String, String> initDefaultHeader() {
//    ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
//    builder.put(CONTENT_TYPE_HEADER, String.format("%s;charset=%s", JSON_CONTENT_TYPE, CHARSET));
//    return builder.build();
//  }
//
//  /**
//   * 创建ssl
//   *
//   * @return
//   */
//  private static SSLContext createIgnoreVerifySSL() {
//    try {
//      SSLContext ctx = SSLContext.getInstance(SSL_PROTOCOL);
//      X509TrustManager tm = new X509TrustManager() {
//        @Override
//        public X509Certificate[] getAcceptedIssuers() {
//          return null;
//        }
//
//        @Override
//        public void checkClientTrusted(X509Certificate[] arg0, String arg1) {
//        }
//
//        @Override
//        public void checkServerTrusted(X509Certificate[] arg0, String arg1) {
//        }
//      };
//      ctx.init(null, new TrustManager[]{tm}, null);
//      return ctx;
//    } catch (Exception e) {
//      log.error("SSL创建失败:" + e);
//    }
//    return null;
//  }
//
//}
