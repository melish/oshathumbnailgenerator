package oshathumbnailgenerator.test;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.Test;

import edw.osha.Converter;

public class TestWord {

	@Test
	public void testDocx() throws Exception {
		InputStream in = TestPowerpoint.class.getResourceAsStream("/test.docx");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Converter.docx2png(in, out);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(out.toByteArray()));
		assertEquals(1121, img.getHeight());
	}
}
