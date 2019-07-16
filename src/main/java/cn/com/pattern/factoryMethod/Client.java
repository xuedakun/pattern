package cn.com.pattern.factoryMethod;

public class Client {
	public static void main(String[] args) {
		ExportFactory htmlFactory = new ExportHtmlFactory();
		ExportFile ef = htmlFactory.factory("standard");
		ef.export("xxxxx");

	}
}
