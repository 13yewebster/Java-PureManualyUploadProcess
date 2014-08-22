package com.bye.project;


import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	String pathTemp = "/Users/ByeWebster/Desktop/TempFiles/tmp";
	String pathStore = "/Users/ByeWebster/Desktop/TempFiles";
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if(isMultipart){

		//List items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

		String contentType = request.getContentType();
        out.println("String contentType : " + contentType +"\n");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        int formDataLength = request.getContentLength();
        out.println("int formDataLength : " + formDataLength +"\n");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");

        DataInputStream dataStream = new DataInputStream(request.getInputStream());
        byte[] datas = new byte[formDataLength];
        out.println("byte datas[] : " + new byte[formDataLength] +"\n");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");

        int totalBytes = 0;
        while (totalBytes < formDataLength) {
            int bytes = dataStream.read(datas, totalBytes, formDataLength);
            totalBytes += bytes;
        }

        out.println("int totalBytes :" + totalBytes +"\n");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");

        String reqBody = new String(datas, "ISO-8859-1");
        out.println("String reqBody :" + reqBody +"\n");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");

        String filename = reqBody.substring(reqBody.indexOf("filename=\"") + 10);
        out.println("String filename :" + filename +"\n");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/> Number Match To filename=\" " + (reqBody.indexOf("filename=\"") + 10));
        out.println("<br/>");
        out.println("<br/>");

        filename = filename.substring(0, filename.indexOf("\n"));
        out.println("filename :" + filename +"\n");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>" + filename.lastIndexOf("\\") + "  " + filename.indexOf("\""));
        out.println("<br/>");
        filename = filename.substring(filename.lastIndexOf("\\") + 1, filename.indexOf("\""));
        out.println("filename :" + filename +"\n");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");

        String boundary = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("ContentType : " + contentType + " <br/>");
        out.println("ContentType check Match To = : "+ (contentType.lastIndexOf("=") + 1));
        out.println("<br/>ContentLength : "+ (contentType.length()));
        out.println("<br/>");

        out.println("String boundary :" + boundary +"\n");
        out.println("<br/>");
        out.println("<br/>");

        int pos;
        pos = reqBody.indexOf("filename=\"");
        out.println("<br/>");
        out.println("<br/>");
        out.println("pos :" + pos +"\n");
        pos = reqBody.indexOf("\n", pos) + 1;
        out.println("<br/>");
        out.println("<br/>");
        out.println("pos :" + pos +"\n");
        pos = reqBody.indexOf("\n", pos) + 1;
        out.println("<br/>");
        out.println("<br/>");
        out.println("pos :" + pos +"\n");
        pos = reqBody.indexOf("\n", pos) + 1;
        out.println("<br/>");
        out.println("<br/>");
        out.println("pos :" + pos +"\n");
        out.println("<br/>");
        out.println("<br/>");

        int boundaryLoc = reqBody.indexOf(boundary, pos) - 4;
        out.println("int boundaryLoc :" + boundaryLoc +"\n");
        out.println("<br/>");
        out.println("<br/>");
        int startPos = ((reqBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
        out.println("int startPos :" + startPos +"\n");
        out.println("<br/>");
        out.println("<br/>");
        int endPos = ((reqBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;
        out.println("int endPos :" + endPos +"\n");
        out.println("<br/>");
        out.println("<br/>");

        FileOutputStream fileOutputStream = new FileOutputStream(pathStore+"/"+filename);
        fileOutputStream.write(datas, startPos, (endPos - startPos));
        out.println("datas:" + datas + " startPos : " + startPos + "(endPos - startPos) :" + (endPos - startPos));
        fileOutputStream.flush();
        fileOutputStream.close();


   }

  }

}
