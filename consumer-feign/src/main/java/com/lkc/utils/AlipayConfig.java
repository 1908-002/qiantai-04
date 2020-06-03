package com.lkc.utils;

public class AlipayConfig {

        // 应用ID,支付宝提供的APPID，上面截图中有提到
        public static String app_id = "2016102200738837";

        // 商户私钥，您的PKCS8格式RSA2私钥
        public static String merchant_private_key = "MIIEuwIBADANBgkqhkiG9w0BAQEFAASCBKUwggShAgEAAoIBAQCrZ+2k5pLoOFdPe4IMHx/Uz/YM56pj2XQNG5b/zbbZMxeggKfvG5QeCnBtDzYaU5BN3rk7Uyk2pYmB4KQY0q8hcxkyow7bREP5z+PSSYFCk6Yl3VA0abKavHD2/cX5oCL8kb6g1tmu+TIh//ef9KCtR4kVy6m1jsrz752cCZsrwKwYLc61zJvNUi2QWu9dC/PMedkGdheN5M7wTqPUE73JeCMAeDeAem6PG/cmNx47KMjEZe6Al5eN/9QfRImRLualZT+ldZOVFlgcf5H8ArC2Pdr7CabQ6yOVkDYFSOC5U4RDnH3E4c3RT5P55k+pu58j4CQ7Doe8YhVjubtfzH3TAgMBAAECgf8xi9kl0YCln6OdVhZBar3IxlRZZp3aPwFMyKzdRJmWLy6lNotUkqQ+CsZ0v/Djq0QLPlZMz70aDr+wyz6j7kKxaJPgD0I8H3+GtpEkOBslI4jjaRXGEMeP8ui0fKa9gYybdYWk+HX0HhRfv53UnuHTNNprcnOcB6qi2KC2ehBglNaiwhj61tnZu0qV9GJIv1xGDNa+D/vUKzGBiCNbnE5t+oBRcy1NUzqJl5I/aUFeU4v+oid/Mge/5mCEGxbdV8GIkfusAqIC7GbArP+XO1A1sMtN1zf38bw2bZrs48AnTERTgNdmFSaF20DulshsgEB5K73hChU/PieTHfTIrKECgYEA9C6LpD+V6OW5W0zvg0vCS7VGpS+Mb4pZThBT5AxIRiCPrvKTJF51aImh/CiFrcThB9tBZQbO5QsYZB2WO6ws/h67GpcAcoG7WKZXW5WratWuS/hroRj5f8TBC8zdS8SH30DngF3ayD/p8N6RUSdtJjaUiI3EWSk2XMzr6vvQB5sCgYEAs7Otd3nkQdDTJDFFeRRK4tQMwmUXk6InGjdqrt1rw6EA6KZHr6qpPdkfqISsPVUh/hIIWJe1k5D7wZg6DERgoE4vRtA1zfk2+anINXpNOfjDb+S+zwbyqjEb50SL1oliaAprwu41jdoFi59V+wFTDcXHZ5y/71BQYrvrHNdtMikCgYBS1GMsESGyAhMxRFTO7ej3s4NGT23M/Fo039cFOaFeoHb8+m4tXRlon59iIQDPpERNXPO+6GNQUMYyV9L5ZPtSLGx9pZFSRm2dsbdaatfeAqQAQ0GHQSiJTd3KOfErXXxVn/enlK69VOjveyBCLiSZXNRfye876330VtMEP+0eVwKBgG2/iWyTY+USPTE4aj6FNysK6HP8u4ZtnMX1HFGJZxxGA0ES9GsDpnLgXOZViL+4c5cwuiopFTr3a9oTNzhwtjaRKWxtEr8luf6GQ4DtnaaPGAUJRcM4chGhBnKauXCf3Rq/aorVYp2sjoB0IlW2vFuH872CzPHCMiXqsK+fnc/pAoGBAIfZBRyGTglFr0n+a7O3CAaB6aL2yDtOWVz94wMbx8TwCE8dVQE4Zspq8MQADlj2MjiRjsOqy70uPVPXIibdCz8QC8VuS7aKkNa5TUFgi4vYqql8e9ydUQa3Bsn/CySXfyQMwY08nFa/dUtlS9ptOxLjwP0FQJoVFyJniNX7EYQo";

        // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/appDaily.htm 对应APPID下的支付宝公钥。
        public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjL0flccTW8t91rnbYOqDy30OW7J+bh4oLmd5BxwYkIiRYyxRmQ5Roh3BEpJFubYguJzBzKOnSLPOIvmKBG94lCt8zIJ5zBSiyrKrx5ey0MN4k0ZzXwfLaR0WlIx8uyZQkP0AI3QiqYCn16Ca3i0ctlyooVMTPaWv4AOeeBUO4x2X6Gr1FweBx+O8J076ooErigU4vG69g85h4Dwpf32051ZF+HQ1bnEEPF2rKQnm+Gc5TVAlr2Rp3ZVDZNciIaYCneXv9MBkpjut/NiIEzyER6PCsHFaB9mz0vPUgDp1QHjTDyCUO8bzXU8bUpvyMjcww4zR2E1D4R2amBlzGjcSiwIDAQAB";

        // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问.如果只是测试使用,那么设置成自己项目启动后可以访问到的一个路径,作为支付宝发送通知的路径(有什么用暂时没发现)
        public static String notify_url = "http://localhost:8080/return_url";

        // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问.如果只是测试使用,那么设置成自己项目启动后可以访问到的一个路径.是支付正常完成后,会访问的路径.
        public static String return_url = "http://localhost:8080/";
        // 签名方式，注意这里，如果步骤设置的是RSA则用RSA,如果按照扇面步骤做的话,选择RSA2
        public static String sign_type = "RSA2";
        // 字符编码格式
        public static String charset = "utf-8";
        // 支付宝网关
        public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}
