package com.poly.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.bean.Account;
import com.poly.service.AccountService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ExcelController {
	@Autowired
	AccountService accountService;

	@GetMapping("/print-to-excel")
	public ResponseEntity<byte[]> printToExcel() throws IOException {
		List<Account> dataList = getAll(); // Hàm này tạo dữ liệu mẫu

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Data");

		int rowIdx = 0;
		for (Account data : dataList) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(data.getPhoto());
			row.createCell(1).setCellValue(data.getUsername());
			row.createCell(2).setCellValue(data.getPassword());
			row.createCell(3).setCellValue(data.getFullname());
			row.createCell(4).setCellValue(data.getEmail());
			// Thêm cột khác tùy ý
		}

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		workbook.close();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "data.xlsx");

		return ResponseEntity.ok().headers(headers).body(outputStream.toByteArray());
	}

	public final List<Account> getAll() {
		return accountService.findAll();
	}

}
