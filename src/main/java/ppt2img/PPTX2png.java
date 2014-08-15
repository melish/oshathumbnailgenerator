package ppt2img;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

public class PPTX2png {

	static float SCALE = 1.0f;

	public static void toPng(InputStream in, OutputStream out) throws IOException {

		XMLSlideShow ppt;
		try {
			ppt = new XMLSlideShow(OPCPackage.open(in));
		} catch (InvalidFormatException e) {
			throw new IOException(e);
		}

		Dimension pgsize = ppt.getPageSize();
		int width = (int) (pgsize.width * SCALE);
		int height = (int) (pgsize.height * SCALE);

		if (ppt.getSlides().length > 0) {
			XSLFSlide firstSlide = ppt.getSlides()[0];

			BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = img.createGraphics();

			// default rendering options
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

			graphics.setColor(Color.white);
			graphics.clearRect(0, 0, width, height);

			graphics.scale(SCALE, SCALE);

			// draw stuff
			firstSlide.draw(graphics);

			ImageIO.write(img, "png", out);
			out.close();
		}
	}

}
