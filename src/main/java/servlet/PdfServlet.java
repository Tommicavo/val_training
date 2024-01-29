package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import model.bean.GruppoBean;
import model.bean.UtenteBean;
import model.dao.GruppoDao;
import model.dao.UtenteDao;

@WebServlet("/PdfServlet")
public class PdfServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strIdUtente = request.getParameter("idUtente");
        Long idUtente = Long.valueOf(strIdUtente);
        UtenteDao utenteDao = new UtenteDao();
        UtenteBean utenteBean = utenteDao.findById(idUtente);

        String strIdGruppo = request.getParameter("idGruppo");
        Long idGruppo = Long.valueOf(strIdGruppo);
        GruppoDao gruppoDao = new GruppoDao();
        GruppoBean gruppoBean = gruppoDao.findById(idGruppo);

        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            
            String content = "";
            content += utenteBean.toString() + "\n";
            content += gruppoBean.toString() + "\n";
            
            document.open();
            document.add(new Paragraph(content));
            document.close();
                        
            response.setContentType("application/pdf");
            String attachment = "attachment; filename=Valutazione_" + utenteBean.getNomeUtente() + "_" + utenteBean.getCognomeUtente()  + ".pdf";
            response.setHeader("Content-Disposition", attachment);
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
