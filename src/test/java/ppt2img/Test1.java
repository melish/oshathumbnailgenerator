package ppt2img;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.junit.Assert.*;
import org.junit.Test;

public class Test1 {

	@Test
	public void test1() throws Exception {
		InputStream in = Test1.class.getResourceAsStream("/test.pptx");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PPTX2png.toPng(in, out);
		assertEquals(46793, out.toByteArray().length);
	}
}
