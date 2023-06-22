package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat.Encoding;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encoding = "utf-8";
		
		File currentPath = new File("D:\\박련옥 java\\file_repo");
		// 파일을 올리는 공간에 파일을 올리고자하는 용량과 경로를 설정
		// 파일공간에 대한 설정을 위한 클래스 DiskFileItemFactory 
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 파일 설정과 관련된 여러가지 일을 하는 클래스, 파일과 관련된 내용을 항목(item) 형태로 저장
		// 파일 아이템이란 예를들어 파일이름, 파일크기
		
		factory.setRepository(currentPath);
		// DiskFileItemFactory 클래스의 setSizeThreshold() 메서드는 메모리에 보관할 
		// 임시 크기 임계값을 설정하는데 사용됨. 이메서드에서  사용되는 단위는 바이트(Byte)
		
		// setSizeThreshold() 메서드에 전달하는 매개변수는 바이트 단위로 지정되며 임시 파일의 크기가
		// 이 임계값보다 크면 디스크에 파일이 저장됨. 임시 파일의 크기가 임계값보다 작으면 메모리에 보관함.
		// 이렇게 함으로써 작은 파일은 메모리에 보관되어 더 빠른 처리가 가능하고, 큰파일은 디스크에 저장되어 메모리 사용량을 줄일수 있음
		factory.setSizeThreshold(1024*1024);//파일 용량 설정
		
		
		// 파일을 올리는 행위를 하는 클래스
		ServletFileUpload upload = new ServletFileUpload(factory);
		System.out.println("파일 업로드 객체 : " + upload);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			//request객체에서 매개변수를 List로 가져옴
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem)items.get(i);
				// items 는 리스트타입으로 FileItem로 강제 현변환하여  
				// 파일 업로드창에서 업로드된 항목들을 하나씩 가져옴
				if (fileItem.isFormField()) { // 폼 필드이면 전송된 매개변수 값을 출력함
					System.out.println(fileItem.getFieldName() + " = " + fileItem.getString(encoding));
				} else {
					System.out.println("매개변수이름 : " + fileItem.getFieldName());
					System.out.println("파일이름 : " + fileItem.getName());
					System.out.println("파일크기 : " + fileItem.getSize() + "bytes");
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1);
						// getName()은 데이터가 첨부파일인 경우 파일명 또는 파일경로를 리턴
						// "매개변수이름 : " ~ idx + 1까지 업로드한 파일 이름 가져옴
						File uploadFile = new File(currentPath + "\\" + fileName);
						fileItem.write(uploadFile);
						//업로드한 파일 이름으로 저장소에 파일을 업로드함
					}
				} // 전체 else구분은 폼 필드가 아니면 파일 업로드 기능을 수행하는것임				
			}
			System.out.println(items);
		} catch (Exception e) {
			System.out.println("파일 업로드 요청에서 예외 발생");
//			e.printStackTrace();
		}
	}

}
