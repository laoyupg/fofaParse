public class Help {
    public static  void fofaHelp(){
        System.out.println("title=\"beijing\" 从标题中搜索“北京”\n" +
                "header=\"elastic\" 从http头中搜索“elastic”\n" +
                "body=\"网络空间测绘\" 从html正文中搜索“网络空间测绘”\n" +
                "domain=\"qq.com\" 搜索根域名带有qq.com的网站。\n" +
                "icp=\"京ICP证030173号\" 查找备案号为“京ICP证030173号”的网站\n" +
                "\n" +
                "搜索网站类型资产\n" +
                "js_name=\"js/jquery.js\" 查找网站正文中包含js/jquery.js的资产\n" +
                "搜索网站类型资产 js_md5=\"82ac3f14327a8b7ba49baa208d4eaa15\"\n" +
                "查找js源码与之匹配的资产\n" +
                "icon_hash=\"-247388890\" 搜索使用此icon的资产。\n" +
                "\n" +
                "仅限FOFA高级会员使用\n" +
                "host=\".gov.cn\" 从url中搜索”.gov.cn”\n" +
                "搜索要用host作为名称 port=\"6379\"\n" +
                "查找对应“6379”端口的资产\n" +
                "ip=\"1.1.1.1\" 从ip中搜索包含“1.1.1.1”的网站\n" +
                "搜索要用ip作为名称\n" +
                "ip=\"220.181.111.1/24\" 查询IP为“220.181.111.1”的C网段资产\n" +
                "status_code=\"402\" 查询服务器状态为“402”的资产\n" +
                "protocol=\"quic\" 查询quic协议资产\n" +
                "\n" +
                "搜索指定协议类型(在开启端口扫描的情况下有效)\n" +
                "country=\"CN\" 搜索指定国家(编码)的资产。\n" +
                "region=\"Xinjiang\" 搜索指定行政区的资产。\n" +
                "city=\"Ürümqi\" 搜索指定城市的资产。\n" +
                "cert=\"baidu\" 搜索证书(https或者imaps等)中带有baidu的资产。\n" +
                "cert.subject=\"Oracle Corporation\" 搜索证书持有者是Oracle Corporation的资产\n" +
                "cert.issuer=\"DigiCert\" 搜索证书颁发者为DigiCert Inc的资产\n" +
                "cert.is_valid=true 验证证书是否有效，true有效，false无效\n" +
                "\n" +
                "仅限FOFA高级会员使用\n" +
                "banner=users && protocol=ftp\n" +
                "搜索FTP协议中带有users文本的资产。\n" +
                "type=service 搜索所有协议资产，支持subdomain和service两种\n" +
                "搜索所有协议资产\n" +
                "os=\"centos\" 搜索CentOS资产。\n" +
                "-\n" +
                "server==\"Microsoft-IIS/10\"\n" +
                "搜索IIS 10服务器。\n" +
                "-\n" +
                "app=\"Microsoft-Exchange\"\n" +
                "搜索Microsoft-Exchange设备\n" +
                "after=\"2017\" && before=\"2017-10-01\"\n" +
                "时间范围段搜索 asn=\"19551\" 搜索指定asn的资产。\n" +
                "org=\"Amazon.com, Inc.\" 搜索指定org(组织)的资产。\n" +
                "base_protocol=\"udp\" 搜索指定udp协议的资产。\n" +
                "is_fraud=false new 排除仿冒/欺诈数据\n" +
                "is_honeypot=false 排除蜜罐数据\n" +
                "\n" +
                "仅限FOFA高级会员使用\n" +
                "is_ipv6=true\n" +
                "is_domain=true\n" +
                "\n" +
                "port_size=\"6\" 查询开放端口数量等于\"6\"的资产\n" +
                "\n" +
                "port_size_gt=\"6\" 查询开放端口数量大于\"6\"的资产\n" +
                "\n" +
                "port_size_lt=\"12\" 查询开放端口数量小于\"12\"的资产\n" +
                "\n" +
                "仅限FOFA会员使用\n" +
                "ip_ports=\"80,161\" 搜索同时开放80和161端口的ip\n" +
                "\n" +
                "\n" +
                "ip_country=\"CN\" 搜索中国的ip资产(以ip为单位的资产数据)。\n" +
                "\n" +
                "ip_region=\"Zhejiang\" 搜索指定行政区的ip资产(以ip为单位的资产数据)。\n" +
                "ip_city=\"Hangzhou\" 搜索指定城市的ip资产(以ip为单位的资产数据)。\n" +
                "搜索指定城市的资产\n" +
                "ip_after=\"2021-03-18\" 搜索2021-03-18以后的ip资产(以ip为单位的资产数据)\n" +
                "ip_before=\"2019-09-09\" 搜索2019-09-09以前的ip资产(以ip为单位的资产数据)。\n");
    }

    public static void useHelp(){
        System.out.println(
                "*****************************************\n" +
                "*     fofatoolsV1.0                     *\n" +
                "*     by:OldfishPG                      *\n" +
                "*     2021/6/3                          *\n" +
                "*****************************************\n"+
                "使用方法:xxx.jar -q \"xxxx\" -o \"xxx.xlsx\" -httpcon\n" +
                "-q是查询的语法\n" +
                "-o是保存文件\n"+
                "-httpcon开启http连接 探测状态码 title回显头信息");
        System.out.println("-fofahelp 打印fofa语法");
    }
}
