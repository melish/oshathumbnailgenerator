package oshathumbnailgenerator.test;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.Test;

import edw.osha.Converter;

public class TestPdf {

	@Test
	public void testPdf() throws Exception {
		InputStream in = TestPowerpoint.class.getResourceAsStream("/test.pdf");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Converter.pdf2png(in, out);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(out.toByteArray()));
		assertEquals(540, img.getHeight());
		ImageIO.write(img, "png", new File("test.png"));
	}
}
