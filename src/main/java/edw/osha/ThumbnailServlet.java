package edw.osha;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

public class ThumbnailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		String url = request.getParameter("url");
		if (url == null) {
			response.setContentType("text/plain");
			response.getWriter().println("Missing request parameter: url");
		} else {
			String type = request.getParameter("type");
			if (type == null) {
				type = StringUtils.lowerCase(FilenameUtils.getExtension(url));
			}
			response.setContentType("image/png");
			InputStream in = new URL(url).openStream();
			switch (type) {
			case "ppt":
				Converter.ppt2png(in, response.getOutputStream());
				break;
			case "pptx":
				Converter.pptx2png(in, response.getOutputStream());
				break;
			case "docx":
				Converter.docx2png(in, response.getOutputStream());
				break;
			default:
				response.setContentType("text/plain");
				response.getWriter().println("Missing request parameter: url");
			}
		}
	}
}
