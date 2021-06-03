import com.alibaba.fastjson.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class demo {

    public static void main(String[] args) throws Exception {


        //email=hacker0@tom.com&key=a594d2a38717c5fdff0a5a971cef2278
        String email = "";
        String key ="";

        //查看是否配置config
        File file = new File("config.json");
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;

            while ((str =in.readLine())!=null){
                stringBuffer.append(str);
            }
        }catch (Exception e){
            System.out.println(e);
            return;
        }
        Map<String,String> map = (Map<String, String>) JSONObject.parse(stringBuffer.toString());
        email = map.get("email");
        key = map.get("key");

        String query = "";
        String savexlsx = "";

        //开启http连接
        Boolean ishttpcon = false;

        //判断参数
        for (int i=0;i<args.length;i++){
            if((args[i].equals("-q"))==true){
                query = args[i+1];
            }
            if ((args[i].equals("-o"))==true){
                savexlsx =args[i+1];
            }
            if((args[i].equals("-fofahelp"))==true){
                Help.fofaHelp();
            }
            if((args[i].equals("-httpcon"))==true){
                ishttpcon =true;

            }

        }
        if(query !=""){
            if(email=="" ||key==""){
                System.out.println("[-]email or key为空");
                return;
            }
            String str = Fofa.getFofaQuerry(email,key,query);
            JSONArray jsonArray = Fofa.fofaJsonParse(str);
            if(savexlsx !=""){
                FileOperat.fofaWriteToXlsx(jsonArray,savexlsx);
            }else {
                System.out.println("[*]无保存结果");
            }

        }else {
            Help.useHelp();

        }

        //判断存在fofa爬取后的文件 进行http访问
        if(ishttpcon ==true && savexlsx !=""){
            HTTPService.startConnect(savexlsx);
        }


    }


}
