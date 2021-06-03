import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import sun.misc.BASE64Encoder;
import sun.rmi.runtime.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class Fofa {

    //获取fofa查询数据
    public static String getFofaQuerry(String email, String fofakey, String query) throws Exception {
        //querybase64编码
        String base64encodestr = Base64.encode(query.getBytes());
        //构造fofa路径
        String strurl = "https://fofa.so/api/v1/search/all?email=" + email + "&key=" + fofakey + "&qbase64=" + base64encodestr;
        //System.out.println(strurl);
        URL url = new URL(strurl);
        URLConnection urlConnection = url.openConnection();

        //读取返回后的json数据
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        String line = "";
        StringBuffer sb = new StringBuffer();
        while ((line = bufferedReader.readLine())!=null){
            sb.append(line);
        }

        //传递生json数据
        return sb.toString();
    }


    //处理fofa查询后的生json数据
    public static JSONArray fofaJsonParse(String jsonstr){
        JSONArray results = new JSONArray();
        Boolean resultsCode = false;
        //利用fastjson转化为jsonarray
        Map<String,Object> map = (Map<String, Object>)JSONObject.parse(jsonstr);

        //判断是否成功
        resultsCode = (Boolean) map.get("error");
        if(resultsCode ==false){
            results = (JSONArray) map.get("results");
        }else {
            System.out.println("fofaJsonParse:返回数据错误");
        }
        return results;

    }


}
