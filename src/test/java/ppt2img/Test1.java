package ppt2img;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.Test;

public class Test1 {

	@Test
	public void testPPTX() throws Exception {
		InputStream in = Test1.class.getResourceAsStream("/test.pptx");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PPTX2png.pptx2png(in, out);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(out.toByteArray()));
		assertEquals(540, img.getHeight());
	}
	@Test
	public void testPPT() throws Exception {
		InputStream in = Test1.class.getResourceAsStream("/test.ppt");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PPTX2png.pptx2png(in, out);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(out.toByteArray()));
		assertEquals(540, img.getHeight());
	}
}
