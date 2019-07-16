package cn.com.pattern.factoryMethod;

public class ExportFinancialHtmlFile implements ExportFile {

	@Override
	public boolean export(String data) {
		System.out.println("导出财务版HTML文件");
		return true;
	}

}
