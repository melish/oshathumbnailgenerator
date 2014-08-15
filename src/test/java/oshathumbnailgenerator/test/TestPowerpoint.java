package oshathumbnailgenerator.test;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.Test;

import edw.osha.Converter;

public class TestPowerpoint {

	@Test
	public void testPPTX() throws Exception {
		InputStream in = TestPowerpoint.class.getResourceAsStream("/test.pptx");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Converter.pptx2png(in, out);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(out.toByteArray()));
		assertEquals(540, img.getHeight());
	}
	@Test
	public void testPPT() throws Exception {
		InputStream in = TestPowerpoint.class.getResourceAsStream("/test.ppt");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Converter.pptx2png(in, out);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(out.toByteArray()));
		assertEquals(540, img.getHeight());
	}
}
