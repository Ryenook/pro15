package sec01.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String encoding = "utf-8";
		
		String file_repo = "D:\\박련옥 java\\file_repo";
		String fileName = request.getParameter("fileName");
		String enfileName = URLEncoder.encode(fileName,encoding);
		// 매개변수로 전송된 파일 이름을 읽어옴
		System.out.println("fileName=" + fileName);
		
		OutputStream out = response.getOutputStream();
		// response에서 OutputStream 객체를 가져옴
		
		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile);
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition","attachment; fileName=" + enfileName);
		// HTTP 응답 헤더에 "Cache-Control"
		
		FileInputStream in = new FileInputStream(f);
		
		byte[] buffer = new byte[1024*8];
		while (true) { // 버퍼 기능을 이용해 파일에서 버퍼로 데이터를 읽어와 한꺼번에 출력함
			int count = in.read(buffer);
			if (count == -1) 
				break;
			
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}

}