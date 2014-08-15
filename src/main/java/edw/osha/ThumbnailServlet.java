package edw.osha;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppt2img.PPTX2png;

public class ThumbnailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		String url = request.getParameter("url");
		if (url != null) {
			response.setContentType("image/png");
			InputStream in = new URL(url).openStream();
			PPTX2png.toPng(in, response.getOutputStream());
		} else {
			response.setContentType("text/plain");
			response.getWriter().println("Missing request parameter: url");
		}
	}

}
