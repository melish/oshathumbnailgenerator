package ppt2img;

import java.io.OutputStream;

import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class Test2 {

	// @Test
	public void test() throws Exception {
		String filename = "c:/edw/projects/sandbox2/org.samples.docxconverters.docx4j/docx/Resume.docx";
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new java.io.File(filename));
		FOSettings foSettings = Docx4J.createFOSettings();
		// foSettings.setFoDumpFile(new java.io.File(filename + ".fo"));
		foSettings.setWmlPackage(wordMLPackage);

		OutputStream os = new java.io.FileOutputStream(filename + ".pdf");
		Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

	}
}
