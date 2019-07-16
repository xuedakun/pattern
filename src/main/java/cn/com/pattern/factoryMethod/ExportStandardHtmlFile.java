package cn.com.pattern.factoryMethod;

public class ExportStandardHtmlFile implements ExportFile {

	@Override
	public boolean export(String data) {
		System.out.println("导出标准版HTML文件");
		return true;
	}

}
