/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entidades.Llamada;
import servicios.ServicioLlamada;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.toedter.calendar.JDateChooser;
import com.opencsv.CSVWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LlamadasFrame extends JFrame {

    private JDateChooser fechaInicioChooser;
    private JDateChooser fechaFinChooser;
    private JTextArea llamadasTextArea;
    private JButton filtrarButton;
    private JButton generarCSVButton;
    private List<Llamada> llamadas;
    private ServicioLlamada servicioLlamada;

    public LlamadasFrame() {
        // Configurar la ventana
        setTitle("Filtrar Llamadas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Crear los componentes
        fechaInicioChooser = new JDateChooser();
        fechaFinChooser = new JDateChooser();
        llamadasTextArea = new JTextArea();
        filtrarButton = new JButton("Filtrar");
        generarCSVButton = new JButton("Generar CSV");

        // Configurar el layout
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JPanel fechaPanel = new JPanel();
        fechaPanel.add(new JLabel("Fecha de inicio:"));
        fechaPanel.add(fechaInicioChooser);
        fechaPanel.add(new JLabel("Fecha de fin:"));
        fechaPanel.add(fechaFinChooser);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(filtrarButton);
        buttonPanel.add(generarCSVButton);

        contentPane.add(fechaPanel, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(llamadasTextArea), BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Asignar acciones a los botones
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarLlamadas();
            }
        });

        generarCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarCSV();
            }
        });

        // Inicializar la lista de llamadas (aquí deberías cargar tus datos reales)
        llamadas = new ArrayList<>();
        llamadas.add(new Llamada(/*datos de la llamada 1*/));
        llamadas.add(new Llamada(/*datos de la llamada 2*/));
        llamadas.add(new Llamada(/*datos de la llamada 3*/));
    }

    private void filtrarLlamadas() {
        Date fechaInicio = fechaInicioChooser.getDate();
        Date fechaFin = fechaFinChooser.getDate();

        List<Llamada> llamadasFiltradas = servicioLlamada.buscarLlamadasPorFechas(fechaInicio, fechaFin);

        mostrarLlamadas(llamadasFiltradas);
    }

    private void mostrarLlamadas(List<Llamada> llamadas) {
        llamadasTextArea.setText("");
        for (Llamada llamada : llamadas) {
            llamadasTextArea.append(llamada.toString() + "\n");
        }
    }

    private void generarCSV() {
        // Obtener las llamadas filtradas
        Date fechaInicio = fechaInicioChooser.getDate();
        Date fechaFin = fechaFinChooser.getDate();
        List<Llamada> llamadasFiltradas = servicioLlamada.buscarLlamadasPorFechas(fechaInicio, fechaFin);

        // Crear el diálogo de selección de archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo CSV");

        // Filtrar solo archivos con extensión .csv
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);

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
                for (Llamada llamada : llamadasFiltradas) {
                    String[] rowData = { llamada.getCliente().getNombreCompleto(), llamada.getEstadoActual(), String.valueOf(llamada.getDuracion()) };
                    writer.writeNext(rowData);
                }

                writer.close();

                JOptionPane.showMessageDialog(this, "Archivo CSV generado correctamente.", "Generar CSV",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al generar el archivo CSV: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LlamadasFrame frame = new LlamadasFrame();
                frame.setVisible(true);
            }
        });
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
