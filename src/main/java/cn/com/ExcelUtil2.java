package cn.com;

import com.csvreader.CsvReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExcelUtil2 {
    //    private static final String[][] excelHeader = {{"统计时间", "time"},
//            {"日累计流量(m3)", "aveValue"},
//            {"最小值(L/s)", "minValue"}, {"最大值(L/s)", "maxValue"}, {"参考降雨量(mm)", "referValue"}
//    };
    private static final String[][] excelHeader = {{"统计时间", "time"},
            {"日均值(m)", "aveValue"},
            {"最小值(m)", "minValue"}, {"最大值(m)", "maxValue"}, {"参考降雨量(mm)", "referValue"}
    };

    public static List<Rainfall> readExcel(File file) throws IOException {
        System.out.println("..........开始写：" + file.getAbsolutePath());
        // 扩展名为空时，
        if (file == null || StringUtils.isEmpty(file.getAbsolutePath())) {
            throw new IOException("文件路径不能为空！");
        }

        // 获取扩展名
        List<Rainfall> returnData = null;
        try {
            if (file.getName().endsWith("xls")) { // 使用xls方式读取
                returnData = readExcel_xls(file);
            } else if (file.getName().endsWith("xlsx")) { // 使用xlsx方式读取
                returnData = readExcel_xlsx(file);
            } else if (file.getName().endsWith("csv")) {
                returnData = readExcel_csv(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnData;
    }

    private static List<Rainfall> readExcel_csv(File file) {
        List<Rainfall> rowList = new ArrayList<Rainfall>();
        CsvReader csvReader = null;
        try {
            csvReader = new CsvReader(file.getAbsolutePath());
            // 读表头
            csvReader.readHeaders();
            String[] values;
            Rainfall rainfall;
//            double aveAll = 0D;
//            double minAll = 0D;
//            double maxAll = 0D;
//            double referAll = 0D;
            while (csvReader.readRecord()) {
                values = csvReader.getRawRecord().split(",");
                rainfall = new Rainfall();
                if (StringUtils.isNotEmpty(values[0])) {
                    rainfall.setTime(DateUtils.format("yyyy/M/d", DateUtil.string2Date(values[0], "yyyy-MM-dd")));
                    rainfall.setAveValue(values[1]);
                    rainfall.setMinValue(values[2]);
                    rainfall.setMaxValue(values[3]);
                    rainfall.setReferValue(values[4]);
//                    if (values[1] != null) {
//                        aveAll += Double.parseDouble(values[1]);
//                    }
//                    if (values[2] != null) {
//                        minAll += Double.parseDouble(values[2]);
//                    }
//                    if (values[3] != null) {
//                        maxAll += Double.parseDouble(values[3]);
//                    }
//                    if (values[4] != null) {
//                        referAll += Double.parseDouble(values[4]);
//                    }
                    rowList.add(rainfall);
                }
            }
//            rainfall = new Rainfall();
//            rainfall.setAveValue(aveAll + "");
//            rainfall.setMinValue(aveAll + "");
//            rainfall.setAveValue(aveAll + "");
//            rainfall.setAveValue(aveAll + "");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return rowList;
    }

    private static String getStr(String str) {
        DecimalFormat df = new DecimalFormat("##.00");
        return df.format(str);
    }

    private static List<Rainfall> readExcel_xlsx(File file) throws Exception {


        XSSFWorkbook wb = null;
        List<Rainfall> rowList = new ArrayList<Rainfall>();
        try {
            InputStream fis = new FileInputStream(file);
//            InputStream fis = file.getInputStream();
            OPCPackage op = OPCPackage.open(fis);
            // 去读Excel
            wb = new XSSFWorkbook(op);
            // 读取Excel 2007版，xlsx格式
            rowList = readExcel(wb);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowList;
    }

    private static List<Rainfall> readExcel(Workbook wb) {
        List<Rainfall> rowList = new ArrayList<Rainfall>();
        Rainfall rainfall = null;
        int sheetCount = 1;// 需要操作的sheet数量

        Sheet sheet = null;
        // 操作多个sheet
        sheetCount = wb.getNumberOfSheets();// 获取可以操作的总数量

        int startSheetIdx = 0;
        int endSheetIdx = 0;
        // 获取sheet数目
        for (int t = startSheetIdx; t < sheetCount + endSheetIdx; t++) {
            // 获取设定操作的sheet
            sheet = wb.getSheetAt(t);
            // 获取最后行号
            int lastRowNum = sheet.getLastRowNum();


            Row row = null;
            int startReadPos = 1;
            int endReadPos = 0;
            // 循环读取
            for (int i = startReadPos; i <= lastRowNum + endReadPos; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    // 获取每一单元格的值
                    rainfall = new Rainfall();
                    if (StringUtils.isNotEmpty(getCellValue(row.getCell(0)))) {

                        rainfall.setTime(getCellValue(row.getCell(0)));
                        rainfall.setAveValue(row.getCell(1).toString());
                        rainfall.setMinValue(row.getCell(2).toString());
                        rainfall.setMaxValue(row.getCell(3).toString());
                        rainfall.setReferValue(row.getCell(4).toString());
                        rowList.add(rainfall);
                    }

                }
            }
        }
        return rowList;
    }

    /***
     * 读取单元格的值 xuekun add
     *
     * @param cell
     * @return
     */
    private static String getCellValue(Cell cell) {
        Object result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    result = trim(cell.getStringCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
                        result = sdf.format(cell.getDateCellValue());
                    } else {
                        result = cell.getNumericCellValue();
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    result = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    result = cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_ERROR:
                    result = cell.getErrorCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }

    /**
     * 去除字符串中所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     *
     * @param s
     * @return
     */
    public static String removeAllBlank(String s) {
        String result = "";
        if (null != s && !"".equals(s)) {
            result = s.replaceAll("[　*| *| *|//s*]*", "");
        }
        return result;
    }

    /**
     * 去除字符串中头部和尾部所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     *
     * @param s
     * @return
     */
    public static String trim(String s) {
        String result = "";
        if (null != s && !"".equals(s)) {
            result = s.replaceAll("^[　*| *| *|//s*]*", "").replaceAll("[　*| *| *|//s*]*$", "");
        }
        return result;
    }

    public static List<Rainfall> readExcel_xls(File file) throws IOException {


        HSSFWorkbook wb = null;// 用于Workbook级的操作，创建、删除Excel
        List<Rainfall> rowList = new ArrayList<Rainfall>();

        try {
            // 读取Excel
            InputStream input = new FileInputStream(file);
            POIFSFileSystem fs = new POIFSFileSystem(input);
            wb = new HSSFWorkbook(fs, true);
            // 读取Excel 97-03版，xls格式
            rowList = readExcel(wb);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    /**
     * 自动根据文件扩展名，调用对应的写入方法
     *
     * @param rowList
     * @throws IOException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @Title: writeExcel
     * @Date : 2014-9-11 下午01:50:38
     */
    public static void writeExcel(List<Rainfall> rowList, File file) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();

        XSSFFont fontStyle = wb.createFont();
        fontStyle.setFontName("微软雅黑");
        fontStyle.setFontHeightInPoints((short) 9);
        fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        XSSFSheet sheet = wb.createSheet("处理后数据");
        sheet.setDefaultRowHeightInPoints(30);
        sheet.setDefaultColumnWidth(50);
        XSSFRow row = sheet.createRow((int) 0);

        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFont(fontStyle);

        row = sheet.createRow((int) 0);
        for (int i = 0; i < excelHeader.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i][0]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
        }
        XSSFCell cell = null;
        Rainfall rainfall = null;
        XSSFFont fontStyle2 = wb.createFont();
        fontStyle2.setFontName("微软雅黑");
        fontStyle2.setFontHeightInPoints((short) 9);
        XSSFCellStyle style2 = wb.createCellStyle();
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style2.setFont(fontStyle2);
        style2.setWrapText(true);
        String fieldName = "";
        String getMethodName = null;
        String cellValue = " ";
        HashMap<String, Rainfall> map = new HashMap();
        for (int j = 0; j < rowList.size(); j++) {
            rainfall = rowList.get(j);
            map.put(rainfall.getTime(), rainfall);
        }
        Calendar start = Calendar.getInstance();
        start.set(2018, 0, 1);
        Long startTIme = start.getTimeInMillis();

        Calendar end = Calendar.getInstance();
        end.set(2018, 2, 31);
        Long endTime = end.getTimeInMillis();

        Long oneDay = 1000 * 60 * 60 * 24l;

        Long time = startTIme;
        int rowNumber = 0;
        while (time <= endTime) {
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyy/M/d");
            if (map.containsKey(df.format(d))) {
                rainfall = map.get(df.format(d));
            } else {
                rainfall = new Rainfall();
                rainfall.setTime(df.format(d));
                rainfall.setAveValue("0");
                rainfall.setMaxValue("0");
                rainfall.setMinValue("0");
                rainfall.setReferValue("0");
            }
            row = sheet.createRow((int) rowNumber + 1);
            for (int i = 0; i < excelHeader.length; i++) {
                cell = row.createCell(i);
                fieldName = excelHeader[i][1];
                getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method getMethod = rainfall.getClass().getMethod(getMethodName, new Class[]{});
                Object value = getMethod.invoke(rainfall, new Object[]{});
                if (value == null) {
                    cellValue = "0";
                } else {
                    cellValue = String.valueOf(value);
                }
                if (StringUtils.equals("0.000", value.toString())) {
                    cellValue = "0";
                }
                cell.setCellValue(cellValue);
                cell.setCellStyle(style2);
                // sheet.setColumnWidth(i, String.valueOf(value).getBytes().length * 2 * 256);
            }
            for (int i = 0; i < excelHeader.length; i++) {
                sheet.autoSizeColumn(i);
            }
            rowNumber++;
            time += oneDay;
        }

        createParentFile(file);

        //创建文件流
        OutputStream stream = new FileOutputStream(file);
        //写入数据
        wb.write(stream);
        //关闭文件流
        stream.close();
    }

    private static void createParentFile(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public static List<File> getFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        List<File> filelist = new ArrayList<>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    filelist.addAll(getFileList(files[i].getAbsolutePath())); // 获取文件绝对路径
                } else { // 判断文件名是否以.avi结尾
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println(strFileName);
                    filelist.add(files[i]);

                }
            }

        }
        return filelist;
    }

    public static void main(String[] args) {


        final String directory = "C:\\Users\\hdb\\Desktop\\圣莲岛液位";
        final String directory_treate = "C:\\Users\\hdb\\Desktop\\圣莲岛液位-处理\\";
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<File> filelist = getFileList(directory);
        for (final File file : filelist) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        ExcelUtil2.writeExcel(ExcelUtil2.readExcel(file), new File(directory_treate + file.getParentFile().getName() + "//" + file.getName().replaceAll("csv", "xlsx")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }
//            executorService.awaitTermination()
        System.out.println("处理完毕等待结果！");
        executorService.shutdown();
        //   try {
//            ExecutorService executorService = Executors.newFixedThreadPool(10);
//            final String directory_treate = "C:\\Users\\hdb\\Desktop\\流量0514-处理\\";
//            List<File> filelist = getFileList(directory_treate);
//            Map<String, List<List<Rainfall>>> dataMap = new ConcurrentHashMap<>();
////            final ArrayList<ArrayList<Rainfall>> allList;
//            for (final File file : filelist) {
//
//                executorService.execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            String dataKey = file.getParentFile().getName();
//                            if (dataMap.containsKey(dataKey)) {
//                                List<List<Rainfall>> allList = dataMap.get(dataKey);
//                                allList.add(ExcelUtil2.readExcel(file));
//                            } else {
//                                List<List<Rainfall>> allList = new ArrayList<>();
//                                allList.add(ExcelUtil2.readExcel(file));
//                                dataMap.put(dataKey, allList);
//                            }
//
////                            ExcelUtil2.writeExcel(, new File(directory_treate + file.getParentFile().getName() + "//" + file.getName().replaceAll("csv", "xlsx")));
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//
//            }
//            executorService.shutdown();
//            while (!executorService.awaitTermination(1, TimeUnit.HOURS)) {
//                System.out.println("线程池没有关闭");
//            }
//            String keyStr;
//            List<List<Rainfall>> allList;
//            List<Rainfall> finalList;
//            for (Map.Entry<String, List<List<Rainfall>>> entry : dataMap.entrySet()) {
//                keyStr=entry.getKey();
//                allList=entry.getValue();
//                Rainfall rainfall;
//                double aveAll = 0D;
//                double minAll = 0D;
//                double maxAll = 0D;
//                double referAll = 0D;
//                for (List<Rainfall> dataList:allList){
//                    for (Rainfall rainfall1:dataList){
//
//                    }
//
//                }
//            }
//            System.out.println("线程已经关闭");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
