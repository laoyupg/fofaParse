import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTTPService {


    /**
     * 去掉html源码中的标签
     *
     * @param s
     * @return
     */
    public static String outTag(String s) {
        return s.replaceAll("<.*?>", "");
    }

    //获取网页标签
    public static String getTitle(final String s) {
        List<String> list = new ArrayList<String>();
        String title = "";
        Pattern pa = Pattern.compile("<title>.*?</title>");
        Matcher ma = pa.matcher(s);
        while (ma.find()) {
            list.add(ma.group());
        }
        for (int i = 0; i < list.size(); i++) {
            title = title + list.get(i);
        }
        return outTag(title);

    }

    public static String[] httpConnection(String strurl) throws Exception {
        //判断http协议
        if(!(strurl.startsWith("http"))){
            strurl = "http://" +strurl;
        }
        System.out.println(strurl);

        URL url = new URL(strurl);
        String[] strs = new String[]{"","",""};
        try {

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            //读取网页内容
            String temp = "";
            StringBuffer sb = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            while ((temp = bufferedReader.readLine()) != null) {
                sb.append(temp);
            }
            bufferedReader.close();

            //匹配内容标题
            String title = getTitle(sb.toString());
            System.out.println(title);
            strs[0] = String.valueOf(httpURLConnection.getResponseCode());
            strs[1] = title;
            strs[2] = httpURLConnection.getHeaderFields().toString();
            return strs;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //-u xxx.xlsx读取文件,开启多线程访问里面的网址获取信息，再保存。
    public static void startConnect(String filename) throws Exception{
        File file =new File(filename);

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));

        //读取url列表
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        int rownum = sheet.getPhysicalNumberOfRows();
        String[] urls = new String[rownum-1];
        Cell cell = null;
        for(int i = 0;i<rownum-1;i++){
            //获取当前列数
            XSSFRow xssfRow = sheet.getRow(i+1);
            String str =xssfRow.getCell(0).toString();
            //urls[i] = str;
            String[] strs = httpConnection(str);

            //写入文件
            Row currentRow = sheet.getRow(i+1);
            if(strs !=null){
                for (int j =0;j<strs.length;j++){
                    cell = currentRow.createCell(j+3);
                    cell.setCellValue(strs[j]);
                }
            }


        }

        FileOutputStream stream= FileUtils.openOutputStream(file);
        xssfWorkbook.write(stream);
        xssfWorkbook.close();
        stream.close();
    }


}
