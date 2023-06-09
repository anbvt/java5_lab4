package com.fpoly.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamService{
	@Autowired
	HttpServletRequest req;

	/**
	 * Đọc chuỗi giá trị của tham số
	 * @param name tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public String getString(String name, String defaultValue) {
		String text = req.getParameter(name);
		if (!text.isEmpty()) {
			return text;
		}
		return defaultValue;
	}

	/**
	 * Đọc số nguyên giá trị của tham số
	 * @param name tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public int getInt(String name, int defaultValue) {
		String number = req.getParameter(name);
		if (!number.isEmpty()) {
			return Integer.parseInt(number);
		}
		return defaultValue;
	}

	/**
	 * Đọc số thực giá trị của tham số
	 * @param name tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public double getDouble(String name, double defaultValue) {
		String number = req.getParameter(name);
		if (!number.isEmpty()) {
			return Double.parseDouble(number);
		}
		return defaultValue;
	}

	/**
	 * Đọc giá trị boolean của tham số
	 * @param name tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public boolean getBoolean(String name, boolean defaultValue) {
		String flag = req.getParameter(name);
		if (flag != null) {
			return Boolean.parseBoolean(flag);
		}
		return defaultValue;
	}

	/**
	 * Đọc giá trị thời gian của tham số
	 * @param name tên tham số
	 * @param pattern là định dạng thời gian
	 * @return giá trị tham số hoặc null nếu không tồn tại
	 * @throws RuntimeException lỗi sai định dạng
	 */
	public Date getDate(String name, String pattern) {
		String date = req.getParameter(name);
		try {
			SimpleDateFormat dateOther = new SimpleDateFormat(pattern);

			if (!date.isEmpty()) {
				Date dateReturn = dateOther.parse(date);
				return dateReturn;
			}

		} catch (RuntimeException e) {
			// pattern sai dinh dang
			e.printStackTrace();
		} catch (ParseException e) {
			// param sai dinh dang khong the parse sang date
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Lưu file upload vào thư mục
	 * @param file chứa file upload từ client
	 * @param path đường dẫn tính từ webroot
	 * @return đối tượng chứa file đã lưu hoặc null nếu không có file upload
	 * @throws RuntimeException lỗi lưu file
	 */
	public File save(MultipartFile file, String path) {
		// TODO Auto-generated method stub
		try {
			if(!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				
				File f = new File(path + fileName);
				try {
					file.transferTo(f);
					return f;
				} catch (IOException e) {
					// luu khong thanh cong
					e.printStackTrace();
				}
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

}
