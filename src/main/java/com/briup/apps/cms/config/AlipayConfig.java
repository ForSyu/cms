package com.briup.apps.cms.config;

import java.io.FileWriter;
import java.io.IOException;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101500689468";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDWiGRTgQaBENtssiJ1tH+U9373O6NszvfvXBn0VbaZf+bUE2IBhxJjhBI9CWmwuyEKxBVBRmq2XyOHQV684wzly5BKx4zwEzVGa1OmahB3vJBPkgifEMikXeLfAIj/oUmozYo8zI/cDDO3iCIjfF/rkUgizqw715g342MiJxbUxY/7ontpo9ydSv5ph/WNS91J6imKy9q74oBF5If3508kAx5aNvIQnu3btYcOm+XHECeBp6G3rcMzfjG9RKQIMKyT7wZI9momaGxy5URmVuKTB0nQFBWPd6CB8bsyXXqV6akM+TpQI1qza42BAar3I3MoZHhFf5p5TP2AMiFtuEYZAgMBAAECggEAEYDRRqrZQACDFow2GYpfemTy+/Lms4LzYZkPGQtBOabgy17FeUBu9KWa41X4RI4P9RPodAntvPFoManYs+qGa90+6Yr8ab33c8Zf7czriQlecM+GWowBAsASOYWOp+Sd4OLcK3e5KQfp1EiMGH8WSF7zFrvr+3nslmq79NZhm3xYnXY+Ozk18RBZe5PRZHOstq8IKo2aUhIq7r1mdJzOXLz6qZtnyeb9OCqgzGnM5THa6K5c5w9CVp17qCqOQsTYdn1tmVLifSmfFGeDmI5Z6JtpnDgzSbKtb+rac2ABW/BbaSv3ORWQQKPudHTTbA/dDGiY9uBLgEGlB113y0XDrQKBgQD67df0y4FcUQNFCccmAgQIUe+6wik70rTGSChLLk9b2zdsFee1s3fRxNbMhKIpTudqJLQZoiG7Vnb+YvF8uZjlwvPlFk5m7HSf85WPbsxLA7F+I02QJ+lbocDVm7toVHKo6eU4MCZmXT1s3byIROJp7N+6hxoqZxNAXokNGiWjswKBgQDa3kF3wN9eiARh59qeN67/5b/KTBHMRCuGJPqQefYHzDPbs1Vw3tzxIsx9NMXrDeIp4BMBxKBoS1iUObXO6PG6HN8qQjF6MwE9oVLd5hGVdI5sj2+NNqB0uX4Cco9ErFcxeSS/GCV9ixNoSqK90v0LhIAgijKS8oYW5qbekpm5AwKBgBOK0nbOIpT9+jM2P7xGC+pZ90GkPXHbRxjqJbk1MhkFSZuxWQpdn8dGfTQQYFC3RG6PzTbx2Y6tfTbynbwI+E9sj3IX+qMpZyvN3Kf/CQoOj5QzS6cedJ4eStZX+pB1gziEfsWRemwedtozqqsyMi/tsr7kJrWGsYkh06qhjqzhAoGAURX2ez9hgcwyk3Mqc2N92iBsJa55CYxX86LPkacdl1X4AHU4OlDW2h9iUyCyEptaJtl1MTp/kyQW9RNMYBO9Oo5nv2g2nGc5FnQmFz+dVBmSinW5hj+uwo/WN2Hp4i9XPmT7UDDJ8vELh5/fGySHyzSTo3qPshFXzDQ3rk3x1bECgYEA4c+/HRQtcp+jPDrJBLxiLiQY7VG75AHDl9kJHrKkAjarUQ8tRsY36hQ0VamM1qanJdS96zdHkA45nESEWff7yq8Zjbq+Rv9K3UpmIC8bG1j953u3DTWoxEzRRWm+51+7r8wKxN1VhSt9YPf3W0mlqF9t7PHo3IsINhDiWGYpCu4=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAld6kLycQ54X14QUZUeK3uqCGPDTXYvX6ZO4YfPuEf88n/VEYVj3Bp+fo6XSmLrGiSEZcZZZhP9+fOvoGvPvVwNqr6oxFITaHzXEPQ9phasR6tBD8vFdNSN1zlrA+1vDW4F9xF3TAgfj1SwnduVCDRyYOUAP0sgGIuL8KOmBurJ5IP7ZP9mr85xS3pRmULYObYqw7oXza19DOeA42HNxoqxfZF6EB9/lrc0G6A6sFkB2nSlCPdrYwd9gGSWhClCqXMlkplb5h+uvDEPkvYN8IF30jInJ6zPTlOyR23NbodYpR6DcWEjKXsNF0f4fqZq8Nm4hDDnamNXqiD8hw8+10WQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8081/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:9527/#/dashboard";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:/logs/";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

