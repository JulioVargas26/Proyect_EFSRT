package com.proyect.controller;

import com.proyect.entity.Sala;
import com.proyect.service.SalaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.apachecommons.CommonsLog;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.eclipse.tags.shaded.org.apache.xalan.xsltc.runtime.BasisLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.proyect.util.FunctionUtil.stringToLikeAll;
import static com.proyect.util.MessagesUtil.MESSAGE_LIST_EMPTY;

@Controller
@CommonsLog
public class SalaConsultaController {
    @Autowired
    SalaService serviceSala;

    private final static String DEFAULT_PARAM_VALUE = "-1";
    private final static String DEFAULT_MESSAGE_KEY = "MSG";
    private final static String DEFAULT_LIST_KEY = "LIST";
    private final static String JASPER_REPORT_SALA_URL = "/WEB-INF/reportes/reporteSalaConsulta.jasper";
    private final static String JASPER_REPORT_SALA_IMG = "/WEB-INF/img/logoSalaConsulta.png";
    private final static String REPORT_PDF_FILE_NAME = "ReporteSalaConsulta.pdf";

    @GetMapping("/consultaSalaFiltrar")
    @ResponseBody
    public Map<String, Object> listaComplejo(@RequestParam String numero,
                                             @RequestParam(required = false, defaultValue = DEFAULT_PARAM_VALUE) String piso,
                                             @RequestParam String recursos,
                                             @RequestParam(required = false, defaultValue = DEFAULT_PARAM_VALUE) String numAlumnos,
                                             @RequestParam(required = false, defaultValue = DEFAULT_PARAM_VALUE) String idSede,
                                             @RequestParam(required = false, defaultValue = DEFAULT_PARAM_VALUE) String idTipoSala,
                                             @RequestParam(defaultValue = "true") boolean estado
    ) {
        try {

            List<Sala> salas = serviceSala.buscarSalaConsultaFiltrar(
                    stringToLikeAll(numero),
                    BasisLibrary.stringToInt(piso),
                    stringToLikeAll(recursos),
                    BasisLibrary.stringToInt(numAlumnos),
                    BasisLibrary.stringToInt(idSede),
                    BasisLibrary.stringToInt(idTipoSala),
                    estado ? 1 : 0
            );
            return salas.isEmpty() ? Collections.singletonMap(DEFAULT_MESSAGE_KEY, MESSAGE_LIST_EMPTY)
                    : Collections.singletonMap(DEFAULT_LIST_KEY, salas);
        } catch (Exception e) {
            log.error("Error al procesar la solicitud: " + e.getMessage(), e);
            return Collections.singletonMap(DEFAULT_MESSAGE_KEY, "Ocurrió un error al procesar la solicitud.");

        }
    }

    @GetMapping("/reporteSalaConsultaPdf")
    public void reporte(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam String numero,
                        @RequestParam(required = false, defaultValue = DEFAULT_PARAM_VALUE) String piso,
                        @RequestParam String recursos,
                        @RequestParam(required = false, defaultValue = DEFAULT_PARAM_VALUE) String numAlumnos,
                        @RequestParam(required = false, defaultValue = DEFAULT_PARAM_VALUE) String idSede,
                        @RequestParam(required = false, defaultValue = DEFAULT_PARAM_VALUE) String idTipoSala,
                        boolean estado) {

        try {

            List<Sala> lstSalida = serviceSala.buscarSalaConsultaFiltrar(
                    stringToLikeAll(numero),
                    BasisLibrary.stringToInt(piso),
                    stringToLikeAll(recursos),
                    BasisLibrary.stringToInt(numAlumnos),
                    BasisLibrary.stringToInt(idSede),
                    BasisLibrary.stringToInt(idTipoSala),
                    estado ? 1 : 0
            );

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstSalida);

            String jasperReportFileDirectory = request.getServletContext().getRealPath(JASPER_REPORT_SALA_URL);
            log.info(">> FILE >> " + jasperReportFileDirectory);

            FileInputStream jasperReportStream = new FileInputStream(jasperReportFileDirectory);

            String logoFileDirectory = request.getServletContext().getRealPath(JASPER_REPORT_SALA_IMG);
            log.info(">> LOGO >> " + logoFileDirectory);

            HashMap<String, Object> reportParams = new HashMap<>();
            reportParams.put("LOGO", logoFileDirectory);

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperReportStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParams, dataSource);

            response.setContentType("application/x-pdf");
            response.addHeader("Content-disposition", "attachment; filename=" + REPORT_PDF_FILE_NAME);

            OutputStream outputStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        } catch (Exception e) {
            log.error("Error al generar el reporte: " + e.getMessage(), e);
        }


    }
}
