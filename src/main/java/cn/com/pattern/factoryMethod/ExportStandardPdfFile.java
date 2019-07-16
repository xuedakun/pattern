package cn.com.pattern.factoryMethod;

public class ExportStandardPdfFile implements ExportFile {

	@Override
	public boolean export(String data) {
		System.out.println("导出标准版PDF文件");
		return true;
	}

}
