/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amexico.crud.models;
 
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.servlet.view.document.AbstractPdfView;
 
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.amexico.crud.models.Usuarios;

public abstract class PDFcreator extends AbstractPdfView {
 protected void buildPdfDocument(Map model,
   Document document, PdfWriter writer, HttpServletRequest req,
   HttpServletResponse resp) throws Exception {
  
  Usuarios employee = (Usuarios) model.get("command");
  
  Paragraph header = new Paragraph(new Chunk("Generate Pdf USing Spring Mvc",FontFactory.getFont(FontFactory.HELVETICA, 30)));
  Paragraph by = new Paragraph(new Chunk("Author " + employee.getNombre() + " " + employee.getCorreo(),FontFactory.getFont(FontFactory.HELVETICA, 20)));
  
  document.add(header);
  document.add(by);
 }
}