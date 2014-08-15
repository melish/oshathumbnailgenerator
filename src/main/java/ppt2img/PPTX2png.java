package ppt2img;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.POIXMLException;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

public class PPTX2png {

	static float SCALE = 1.0f;

	public static void pptx2png(InputStream in, OutputStream out) throws IOException {

		File tempFile = File.createTempFile("oshathumbnail", ".ppt");
		FileUtils.copyInputStreamToFile(in, tempFile);
		FileInputStream fileInputStream = new FileInputStream(tempFile);
		
		XMLSlideShow ppt;
		try {
			ppt = new XMLSlideShow(fileInputStream);
		} catch (POIXMLException e) {
			// try ppt?
			ppt2png(tempFile, out);
			return;
		} finally {
			tempFile.delete();
			fileInputStream.close();
		}

		Dimension pgsize = ppt.getPageSize();
		int width = (int) (pgsize.width * SCALE);
		int height = (int) (pgsize.height * SCALE);

		if (ppt.getSlides().length > 0) {
			XSLFSlide firstSlide = ppt.getSlides()[0];

			BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			firstSlide.draw(prepareGraphics(img, width, height));
			ImageIO.write(img, "png", out);
			out.close();
		}
	}

	private static Graphics2D prepareGraphics(BufferedImage img, int width, int height) {
		Graphics2D graphics = img.createGraphics();
		// default rendering options
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

		graphics.setColor(Color.white);
		graphics.clearRect(0, 0, width, height);

		graphics.scale(SCALE, SCALE);
		return graphics;
	}

	public static void ppt2png(File file, OutputStream out) throws IOException {
		SlideShow ppt = new SlideShow(new HSLFSlideShow(file.getAbsolutePath()));
		Dimension pgsize = ppt.getPageSize();
		int width = (int) (pgsize.width * SCALE);
		int height = (int) (pgsize.height * SCALE);
		if (ppt.getSlides().length > 0) {
			Slide firstSlide = ppt.getSlides()[0];
			BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			firstSlide.draw(prepareGraphics(img, width, height));
			ImageIO.write(img, "png", out);
			out.close();
		}
	}

}
