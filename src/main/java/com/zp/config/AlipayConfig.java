package com.zp.config;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

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
    public static String app_id = "2016102100732732";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCOJU0la87ddN4xWwxNDJkCqPZlHxLWAnS3VbLrIuqMZZo2VJiXSjI8mIf2rxuo0bB4dnS2aOkGC3srDnjj1jtryRyeEjs+fU7XFqhXWGNhBbhoCp0gaDiCNRQ9v+5Hd5Hw9zqcQfaodJEbvZ49yqSEv6iarsVJ28bouhEyYXT3YEGUA0fMqtmrSaMI3V2pW/0IYC6ElEik5gwENdQAunRLEfM4UcHnbQuL8EtYYVlkZ8cM93SWXsI+bzLAUjioEZkFIWBXzdRQP/ZCEYPlTU4QPb37x4ig42GvL/WgQEdBqjnbJOFRx8HxRHLrGDJmjhPqthGVwIAH/Tmw3ddT2mArAgMBAAECggEAZFZWR4T7J/2X3jUL0NOEqokELEsr658eLk+zFSG3eNU7bwB2Gc0I+xccWnguyRMDQ3UyW5RgcKDoF3OGyCTwGtyCc94grbKcVV2sBMPimpkEG4Tqdva6dMbs+82gcBgqD3MkjypM54oo5/EIY0vIp9/2LwIRR1p45Mx62RpMC1VxrGFsWxlJNiKlk+pujQLai9feoRgPvJ/n+wL8gVxL/2L67n3N7Rp5B+TtuE6qJEtdC62/+Tkp+GajOteEp3QI73sqZtFzVFrMaaTJlRRDhP7WSiJRN7K4CUf/G422ahqSIlJyHEzIXdYGO2iyAh5U4zLD7Yt2jO2qLLuxyOzIgQKBgQD9Ii78ZR7pw8y5ouM8psmChpNZi1xE7kH8jNLJLsXh2Dk1g11MOi2C8qceEECwjyCBnBMzxucNYdPwNoM+WlBdmIoYYcHAHQs38iKxAzNUH7b6H0zgIYqkMPfc7NPmhPSCh+y8abded842M4nEiQwNhRk0Ek+8DV3xaOv30I6TawKBgQCPwV8x4pk+hsNacKmuZYw+j5O4ZaZxW1LhqGlCaTTwgM7/8EMnX6xC5fZxYS69lzgoETaIK05cvPMd6xsCejLZsETcbZQYBPnN0jKpXoZTP5jhmDi+MJ91Vmtyu6oJLpzNMgCLIldclNi44H2Md+N1etkSkeowJXmTB5e/F6NWQQKBgQCF7DzxmcpWIRpCKJSStSctoGd624lQisFsjVDD0bQtvYje8AY/WxRTEHAsLqsa/k5TZDCglx4M7XIEx8J+DagxLI/7QFUSgAs8aSXDgw739eOHx2GTvwsrvSCVyNJ/Rl5aZPFx6XhzSW1XLcM4sM0opf9klj+LHYNTQpB9RuD3ywKBgFS2gz6GZf/uslgtZBCdTtPfEBHt9PN/+Yt5Du5PyR6hCVrRXwFo475Yfa26syyOXE1gN15vBrKntiy/Sx9em3Ck6y9qc4bkB8E+SRR923JbW+A1L9sEFDO1RYRLCpx2l3hkKuXSyuCH5l6sC9AnJicoyZqj2fmdW9NE+itl5p8BAoGBAN2i7mY5bQaVGD/adUqQ+lJHXIBmDRgvlYaIorixph3WBjIubTfXgoO/fMDJOavOWEu/0cBhvRhzgCOK+yfnqOeX5FJ2aYNa+aekeJJsxViC3xhz6Bzgkb+WNQzUrxHoHxQjQZIfqLguk7+OQxM+UuyZbSCAqFh9yLhXvt4+Dh1n";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1wUPc4wSLwZ10vB63dLdgKdsA5TECqClOqni+UDD0JMKJxhVp6jEhfLMRSGgtJ7nC0shrzw6uRMyJCQCGUK/gZWE7L5nwkR3sobfZvzFoCfsiIekuVTwq29TnHxJSWmhUM9hhm30UrI996DO6HSmm9xPbMhDcjqJebg9JooBT6PwbY/PbyUwEKJ+I+U1XdeMR+zPIq/3sxTVOrKdCVm8OEmpMolopu1W0bsTmOTVOtPS01E1VHPtkbu08RThLcvuvu5EITWP0haHXIvTXBGFtVPZxnqkYciT8rFTRUTVjLdMZKS1q5k3YOjtaSq4xGluZ35RFYzAFyidfT1empwLIwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=124这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8989/dd/front/pay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8989/dd/front/pay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关          沙箱环境下需要替换为：                "https://openapi.alipaydev.com/gateway.do"
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


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
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}


