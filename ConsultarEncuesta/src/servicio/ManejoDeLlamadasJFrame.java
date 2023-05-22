/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import com.opencsv.CSVWriter;
import java.io.File;
import entidades.Llamada;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Brisa
 */
public class ManejoDeLlamadasJFrame {
  

    private List<Llamada> llamadas;

    public ManejoDeLlamadasJFrame() {
        llamadas = new ArrayList<>();
    }

    public void agregarLlamada(Llamada llamada) {
        llamadas.add(llamada);
    }

    public List<Llamada> buscarLlamadasPorFechas(Date fechaInicio, Date fechaFin) {
        List<Llamada> llamadasEncontradas = new ArrayList<>();
        for (Llamada llamada : llamadas) {
            Date fechaLlamada = llamada.getFechaHoraInicio();
            if (fechaLlamada.after(fechaInicio) && fechaLlamada.before(fechaFin)) {
                llamadasEncontradas.add(llamada);
            }
        }
        return llamadasEncontradas;
    }

    // Otros métodos y lógica relacionada con la gestión de llamadas

    public void generarCSV(List<Llamada> llamadas) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Guardar archivo CSV");

    // Filtrar solo archivos con extensión .csv
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv");
    fileChooser.setFileFilter(filter);

    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();

        // Obtener la carpeta "Documentos" del sistema
        String documentosDir = System.getProperty("user.home") + File.separator + "Documents";
        String filePath = documentosDir + File.separator + fileToSave.getName();

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Escribir el encabezado del CSV
            String[] header = { "Nombre del cliente", "Estado actual de la llamada", "Duración de la llamada" };
            writer.writeNext(header);

            // Escribir los datos de cada llamada en el CSV
            for (Llamada llamada : llamadas) {
                String[] rowData = { llamada.getCliente().getNombreCompleto(), llamada.getEstadoActual(), String.valueOf(llamada.getDuracion()) };
                writer.writeNext(rowData);
            }

            writer.close();

            JOptionPane.showMessageDialog(null, "Archivo CSV generado correctamente.", "Generar CSV",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo CSV: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
}


