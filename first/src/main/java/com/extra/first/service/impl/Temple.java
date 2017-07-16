package com.extra.first.service.impl;

/**
 * Created by Kee on 2017/4/19.
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KeeYang on 2017/4/19.
 * @Description :
 */
public class Temple {

    public static List<String> txt2String(File file){
        StringBuilder result = null;
        List<String> urls = new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            String content = "";
            boolean ifAnother = false;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                if (s.contains("/common/front/order/append")){
                    ifAnother = true;
                    result = new StringBuilder();
                }
                if (ifAnother){
                    result.append(s.substring(s.indexOf("/common")));
                }
                if (s.endsWith("HTTP/1.1\" 500 11136")){
                    result.append(s.substring(0,s.indexOf("HTTP/1.1\" 500 11136")));
                    ifAnother = false;
                }
                if (!ifAnother && result != null ){
                    urls.add(result.toString());
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return urls;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("D:/localhost_access_log.2017-04-14.txt");
        List<String> result = txt2String(file);
        String uri = "http://pc.domyauto.com:8080";
        String a = "/common/front/order/append?callback=jQuery18301477867735929954_1492185132719&name=%E5%BB%96%E7%87%95%E8%8C%9C&sex=%E7%94%B7&mobile=13382539988&province=%E6%B1%9F%E8%8B%8F&city=%E6%B1%9F%E9%98%B4%E5%B8%82&agentName=%E6%B1%9F%E9%98%B4%E5%B8%82%E9%87%91%E6%B5%B7%E8%BF%AA%E6%B1%BD%E8%BD%A6%E9%94%80%E5%94%AE%E6%9C%8D%E5%8A%A1%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&agentCode=0&carType=%E5%A4%A7%E8%BF%88X5&carTypeCode=0&mediaName=%E6%98%93%E8%BD%A6&mediaUrl=http%253A%252F%252Fzibo.bitauto.com%252F&terminal=PC&subject=%E5%A4%A7%E8%BF%88X50411&_=1492185159780 HTTP/1.1\" 500 11136112.227.235.92 - - [14/Apr/2017:23:45:19 +0800] \"GET /common/front/order/append?callback=jQuery18301477867735929954_1492185132719&name=%E5%BB%96%E7%87%95%E8%8C%9C&sex=%E7%94%B7&mobile=13382539988&province=%E6%B1%9F%E8%8B%8F&city=%E6%B1%9F%E9%98%B4%E5%B8%82&agentName=%E6%B1%9F%E9%98%B4%E5%B8%82%E9%87%91%E6%B5%B7%E8%BF%AA%E6%B1%BD%E8%BD%A6%E9%94%80%E5%94%AE%E6%9C%8D%E5%8A%A1%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&agentCode=0&carType=%E5%A4%A7%E8%BF%88X5&carTypeCode=0&mediaName=%E6%98%93%E8%BD%A6&mediaUrl=http%253A%252F%252Fzibo.bitauto.com%252F&terminal=PC&subject=%E5%A4%A7%E8%BF%88X50411&_=1492185159780";
//        String url = URLDecoder.decode(uri+a,"utf-8");
//        LambdaHttpClientUtils.doPostByParam(URLEncoder.encode(uri,"utf-8"),"");
//        PostMethod postMethod = new PostMethod(URLEncoder.encode(uri,"utf-8"));
//        HttpClient client = new HttpClient();
//        int status = client.executeMethod(postMethod);
        String urlStr = URLEncoder.encode(uri+URLDecoder.decode(a,"utf-8"),"utf-8");
//        HttpPost httpPost = new HttpPost(uri+a);
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        CloseableHttpResponse response = httpClient.execute(httpPost);
        urlStr = uri+a;
        URL url = new URL("http","pc.domyauto.com",8080,a);
//        URL url = new URL(uri+URLEncoder.encode(URLDecoder.decode(a,"utf-8"),"utf-8"));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

        PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
        printWriter.write(a);
        printWriter.flush();

        conn.connect();
        InputStream in = conn.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
        StringBuffer stringBUffer = new StringBuffer();
        String l = "";
        while ((l=bufferedReader.readLine())!=null){
            stringBUffer.append(l).append("/n");
        }
        System.out.println(stringBUffer.toString());

        if (result != null && result.size() > 0 ){
            for (String s : result){
                System.out.println(s);
//                LambdaHttpClientUtils.doGet(url+s,null);
            }
        }
    }
}
