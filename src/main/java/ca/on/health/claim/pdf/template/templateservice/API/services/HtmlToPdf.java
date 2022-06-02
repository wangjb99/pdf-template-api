package ca.on.health.claim.pdf.template.templateservice.API.services;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.OutputStream;

import java.nio.file.FileSystems;

import org.jsoup.Jsoup;

import org.jsoup.helper.W3CDom;

import org.w3c.dom.Document;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class HtmlToPdf {
    public static void Converter() {
        try {
            //Source HTML
            String inputHTML = "src\\main\\resources\\templates\\basicTemplate.html";
            // Generate PDF file name
            String outputPDF = "src\\main\\resources\\PDFDump\\Output.pdf";
            htmlToPdf(inputHTML, outputPDF);
        } catch (IOException e) {
           
            e.printStackTrace();
        }
    }

    private static Document html5ParseDocument(String inputHtml) throws IOException {
        org.jsoup.nodes.Document doc;
        System.out.println("parsing...");
        doc = Jsoup.parse(new File(inputHtml), "UTF-8");
        System.out.println("parsing done..." + doc);

        return new W3CDom().fromJsoup(doc);
        
    }

    private static void htmlToPdf(String inputHtml, String outputPDF) throws IOException {
        Document doc = html5ParseDocument(inputHtml);
        String baseUri = FileSystems.getDefault().getPath("test", "test").toUri().toString();
        System.out.println(baseUri);
        OutputStream os = new FileOutputStream(outputPDF);
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withUri(outputPDF);
        builder.toStream(os);
        builder.withW3cDocument(doc, baseUri);
        builder.run();
        System.out.println("PDF generation complete");
        os.close();
        
    }
}  
