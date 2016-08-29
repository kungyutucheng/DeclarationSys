package com.gpl.framework.listener;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import com.gpl.framework.model.Progress;

@Component
public class FileUploadProgressListener implements ProgressListener{

	private HttpSession session;
	
	public void setSession(HttpSession session){
		this.session = session;
		Progress status = new Progress();
		session.setAttribute("status", status);
	}
	@Override
	public void update(long bytesRead, long contentLength, int items) {
		Progress status = (Progress) session.getAttribute("status");
		status.setBytesRead(bytesRead);
		status.setContentLength(contentLength);
		status.setItems(items);
	}

}
