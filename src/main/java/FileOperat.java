import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

public class FileOperat {

    //写入fofa结果到文件
    public static void fofaWriteToXlsx(JSONArray jsonArray,String saveXlsx) throws Exception{
        //创建xlsx
        XSSFWorkbook workbook = new XSSFWorkbook();

        //创建工作表sheet
        Sheet sheet = workbook.createSheet();

        //创建第一行,写入标注
        Row row= sheet.createRow(0);
        String[] test = {"网址","ip","端口","状态码","标题","响应头信息"};
        Cell cell = null;
        for (int i=0;i<test.length;i++){
            cell=row.createCell(i);
            cell.setCellValue(test[i]);
        }

        //写入fafa json数据
        for(int i=0 ;i<jsonArray.size();i++){
            JSONArray simglearray = jsonArray.getJSONArray(i);
            Row row2 = sheet.createRow(i+1);
            for (int j =0;j<simglearray.size();j++){
                cell =row2.createCell(j);
                String str = (String) simglearray.get(j);
                cell.setCellValue(str);
            }

        }


        File file = new File(saveXlsx);
        file.createNewFile();
        FileOutputStream stream= FileUtils.openOutputStream(file);
        workbook.write(stream);

        stream.close();

    }



}
