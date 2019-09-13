package com.test.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.test.model.EmployeeModel;
import com.test.service.EmployeeService;

@Controller
public class Client 
{
	
	@Autowired
	private EmployeeService employeeService;

	@ModelAttribute("EmployeeModel")
	public EmployeeModel getEmp() 
	{
		return new EmployeeModel();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerMethod() 
	{
		return "register3";
	}

	@RequestMapping(value = "/register2")
	public ModelAndView registerMethod2(@ModelAttribute("EmployeeModel") EmployeeModel employeeModel2, Model model) 
	{
		System.out.println("registerMethod2 = " + employeeModel2.getEmpName());
		int getId2 = employeeModel2.getEmpId();
		if (getId2 != 0) 
		{
			employeeService.updateEmployee(employeeModel2);
		} 
		else 
		{
			employeeService.addEmployee(employeeModel2);
		}
		List<EmployeeModel> al = employeeService.employeeList();
		model.addAttribute("al", al);
		ModelAndView mav = new ModelAndView("register3", "success", "Employee details successfully inserted");
		return mav;
	}

	@RequestMapping(value = "/employeesDetails", method = RequestMethod.GET)
	public String displayMethod(Model model) 
	{
		List<EmployeeModel> al = employeeService.employeeList();
		model.addAttribute("al", al);
		return "addMoreEmployees";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam int id, Model model) 
	{
		employeeService.delEmployee(id);
		List<EmployeeModel> al = employeeService.employeeList();
		model.addAttribute("al", al);
		return "register3";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView upEmployee(@RequestParam int id, Model model) 
	{
		System.out.println("edit Employee");
		EmployeeModel employeeModel = employeeService.getempbyId(id);
		model.addAttribute("employeeBean", employeeModel);
		return new ModelAndView("register3");
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public String exportExcel(Model model, HttpServletRequest req, HttpServletResponse res) 
			throws Exception 
	{
		List<EmployeeModel> list = employeeService.employeeList();

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Employee Details");

		CellStyle cellStyle = workbook.createCellStyle();
		Font font = workbook.createFont();

		font.setFontName("Arial");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		cellStyle.setFont(font);

		XSSFRow row = spreadsheet.createRow(0);
		XSSFCell cell;
		cell = row.createCell(0);
		cell.setCellValue("EMP ID");
		row.getCell(0).setCellStyle(cellStyle);

		cell = row.createCell(1);
		cell.setCellValue("EMP ADDRESS");
		row.getCell(1).setCellStyle(cellStyle);

		cell = row.createCell(2);
		cell.setCellValue("EMP AGE");
		row.getCell(2).setCellStyle(cellStyle);

		cell = row.createCell(3);
		cell.setCellValue("Emp CF_PWORD");
		row.getCell(3).setCellStyle(cellStyle);

		cell = row.createCell(4);
		cell.setCellValue("EMP DOB");
		row.getCell(4).setCellStyle(cellStyle);

		cell = row.createCell(5);
		cell.setCellValue("EMP GENDER");
		row.getCell(5).setCellStyle(cellStyle);

		cell = row.createCell(6);
		cell.setCellValue("EMP NAME");
		row.getCell(6).setCellStyle(cellStyle);

		cell = row.createCell(7);
		cell.setCellValue("Emp PWORD");
		row.getCell(7).setCellStyle(cellStyle);

		cell = row.createCell(8);
		cell.setCellValue("EMP PHONE NUMBER");
		row.getCell(8).setCellStyle(cellStyle);

		for (int colNum = 0; colNum < 10; colNum++)
			spreadsheet.autoSizeColumn(colNum);

		int rowNum = 1;

		for (EmployeeModel model1 : list) {
			row = spreadsheet.createRow(rowNum++);
			row.createCell(0).setCellValue(model1.getEmpId());
			row.createCell(1).setCellValue(model1.getEmpName());
			row.createCell(2).setCellValue(model1.getEmpDob());
			row.createCell(3).setCellValue(model1.getEmpGender());
			row.createCell(4).setCellValue(model1.getEmpPass());
			row.createCell(5).setCellValue(model1.getEmpCfPass());
			row.createCell(6).setCellValue(model1.getEmpPhno());
			row.createCell(7).setCellValue(model1.getEmpAge());
			row.createCell(8).setCellValue(model1.getEmpAddr());
		}
		ServletOutputStream os = res.getOutputStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} finally {
			bos.close();
		}
		byte[] bytes = bos.toByteArray();

		res.addHeader("Content-disposition", "attachment; filename=Test.xls");
		res.setHeader("Content-Type", "application/vnd.ms-excel");
		os.write(bytes);
		os.flush();
		os.close();
		System.out.println("exceldatabase.xlsx written successfully");

		return "welcome";
	}
	
	@RequestMapping(value="/downloadPDF1", method = RequestMethod.GET)
	public ModelAndView downloadExcel(PdfWriter writer,Model model,
			HttpServletRequest request, HttpServletResponse response) 
					throws DocumentException, IOException 
	{
		List<EmployeeModel> employeeModels = employeeService.employeeList();
		  @SuppressWarnings("unused")
		 
		  
		Document document1=new Document(PageSize.A4);
		Document doc = new Document();
			
		ByteArrayOutputStream baos = null;
	    BufferedOutputStream bos = null;
	    baos = new ByteArrayOutputStream();
		bos = new BufferedOutputStream(baos);
		baos.reset();
		PdfWriter.getInstance(doc, baos);
		doc.open();
			
		doc.add(new Paragraph("EMPLOYEE DETAILS", FontFactory.getFont(FontFactory.HELVETICA, 
				    18, new CMYKColor(0, 255, 255,17))));
			
		PdfPTable table= new PdfPTable(6);
		table.setWidthPercentage(110.0f);
		table.setWidths(new float[] {1.0f, 1.0f, 1.0f,  1.0f, 1.0f, 1.0f});
		table.setSpacingBefore(10);
			
		com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
			
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(null);
		cell.setPadding(6);
			
		cell.setPhrase(new Phrase("Id", font));
		table.addCell(cell);
			
		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);
			
		cell.setPhrase(new Phrase("DOB", font));
		table.addCell(cell);
			
		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Age", font));
		table.addCell(cell);
			
		cell.setPhrase(new Phrase("Phone Number", font));
		table.addCell(cell);
			
			
		for (EmployeeModel model1 : employeeModels) 
		{
			table.addCell(Integer.toString(model1.getEmpId()));
			table.addCell(model1.getEmpName());
			table.addCell(model1.getEmpDob());
			table.addCell(model1.getEmpGender());
			table.addCell(model1.getEmpAge());
			table.addCell(model1.getEmpPhno());
		}
			
			
		ServletOutputStream os = response.getOutputStream();
		
		doc.add(table);
		doc.close();
		try 
		{
			bos.write(baos.toByteArray());
			bos.flush();
			byte[] pdfDocument=baos.toByteArray();
		    
			response.addHeader("Content-disposition", "attachment; filename=Test.pdf");
			response.setHeader("Content-Type", "application/pdf");
			os.write(pdfDocument);
		
		    baos.reset();
		    baos = null;
		    bos.close();
		    os.flush();
		    os.close();
		    }catch (Exception e) {
		    	e.printStackTrace();
			}
	       
			
			System.out.println("pdf created");

			return new ModelAndView("pdfView", "listEmployees", employeeModels);
	}
}
