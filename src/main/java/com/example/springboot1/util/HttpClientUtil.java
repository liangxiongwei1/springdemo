package com.example.springboot1.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: HttpClientUtil
 * @Package com.example.springboot1.util
 * @Description
 * @date 2018/8/31 13:45
 */
@Component
public class HttpClientUtil {

    public String httpGet(String url,String authorization){
        // 1. 得到访问地址的URL
        String msg = "";
        try {
            URL relUrl = new URL(url);
            // 2. 得到网络访问对象java.net.HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) relUrl
                      .openConnection();
            /* 3. 设置请求参数（过期时间，输入、输出流、访问方式），以流的形式进行连接 */
            // 设置是否向HttpURLConnection输出
            connection.setDoOutput(false);
            // 设置是否从httpUrlConnection读入
            connection.setDoInput(true);
            // 设置请求方式
            connection.setRequestMethod("GET");
            // 设置是否使用缓存
            connection.setUseCaches(false);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            connection.setInstanceFollowRedirects(true);
            // 设置超时时间
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.setConnectTimeout(3000);
            if (!authorization.equals("") && !authorization.equals(null)) {
                connection.setRequestProperty("Authorization", authorization);
            }
            // 连接
            connection.connect();
            // 4. 得到响应状态码的返回值 responseCode
            int code = connection.getResponseCode();
            // 5. 如果返回值正常，数据在网络中是以流的形式得到服务端返回的数据
            if (code == 200) { // 正常响应
                    // 从流中读取响应信息
                    BufferedReader reader = new BufferedReader(
                                    new InputStreamReader(connection.getInputStream()));
                    String line = null;

                    while ((line = reader.readLine()) != null) { // 循环从流中读取
                            msg += line + "\n";
                        }
                    reader.close(); // 关闭流
                }
            // 6. 断开连接，释放资源
            connection.disconnect();
            // 显示响应结果
            System.out.println(msg);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }


    public String httpPost(String url,String authorization,String params){
        String msg = "";
        try {
            // 1. 获取访问地址URL
            URL relUrl = new URL(url);
            // 2. 创建HttpURLConnection对象
            HttpURLConnection connection = (HttpURLConnection) relUrl
                    .openConnection();
            /* 3. 设置请求参数等 */
            // 请求方式
            connection.setRequestMethod("POST");
            // 超时时间
            connection.setConnectTimeout(3000);
            // 设置是否输出
            connection.setDoOutput(true);
            // 设置是否读入
            connection.setDoInput(true);
            // 设置是否使用缓存
            connection.setUseCaches(false);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            connection.setInstanceFollowRedirects(true);
            // 设置使用标准编码格式编码参数的名-值对
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.setConnectTimeout(3000);
            if (!authorization.equals("") && !authorization.equals(null)) {
                connection.setRequestProperty("Authorization", authorization);
            }
            // 连接
            connection.connect();
            /* 4. 处理输入输出 */
            // 写入参数到请求中
            OutputStream out = connection.getOutputStream();
            out.write(params.getBytes());
            out.flush();
            out.close();
            // 从连接中读取响应信息
            int code = connection.getResponseCode();
            if (code == 200) {
                   BufferedReader reader = new BufferedReader(
                                   new InputStreamReader(connection.getInputStream()));
                   String line;

                    while ((line = reader.readLine()) != null) {
                           msg += line + "\n";
                       }
                   reader.close();
                }
            // 5. 断开连接
            connection.disconnect();
            // 处理结果
            System.out.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }


    public static String sendPost(String url, String param, String authorization) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
//			if ("https".equalsIgnoreCase(realUrl.getProtocol())) {
//				SslUtil.ignoreSsl();
//			}
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setConnectTimeout(30000);// 连接超时单位毫秒 //
            conn.setReadTimeout(30000);// 读取超时 单位毫秒
            if (!authorization.equals("") && !authorization.equals(null)) {
                conn.setRequestProperty("Authorization", authorization);
            }

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(new String(param.getBytes("utf-8")));
            // flush输出流的缓冲
            out.flush();
            int rescode = conn.getResponseCode();
            // Authorization错误
            if (rescode == 401) {
                return String.valueOf(rescode);
            }
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }



    public static String httpsGet(String url){
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            URL reqURL = new URL(url ); //创建URL对象
            HttpsURLConnection httpsConn = (HttpsURLConnection)reqURL.openConnection();

//取得该连接的输入流，以读取响应内容
            InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream());

//读取服务器的响应内容并显示
            int respInt = 0;

            while( (respInt = insr.read()) != -1){

                System.out.print((char)respInt);
                stringBuffer.append((char)respInt);

             }
//            System.out.print(stringBuffer.toString());
//            JSONObject s = JSONObject.parseObject(stringBuffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

     public static void main(String[] args){
        httpsGet("https://api.weixin.qq.com/sns/jscode2session?appid=wx8167c47f7ca89edd&secret=f7a5c5f11610cbcb288d6c1f9ee0eb76&js_code=033FrR1k10O5tm06fW1k1aRU1k1FrR13&grant_type=authorization_code");
         String s = httpsGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx8167c47f7ca89edd&secret=f7a5c5f11610cbcb288d6c1f9ee0eb76");
//         try {
//             SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//             Date date = sf.parse("2018-01-01 16:44:22");
//             long time = new Date().getTime()+1000;
//             long time1 = System.currentTimeMillis();
//             System.out.println(time);
//             System.out.println(time1);
//             System.out.println(time>time1);
//         } catch (ParseException e) {
//             e.printStackTrace();
//         }

     }

}
