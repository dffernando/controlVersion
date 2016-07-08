/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyec_prog_avanzada;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class despachos extends javax.swing.JFrame {
    Connection conexion = null;
    PreparedStatement sentencia = null;
    PreparedStatement sent=null;
    ResultSet resultado = null;
    String usr = "root";
    String pwd = "";
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/programacion";
    
    
Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    ArrayList <Object[]> datos = new ArrayList<Object[]>();
    Object[] rows;
    
    public despachos() {
        initComponents();
        this.setTitle("Despachos");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Item = new javax.swing.JComboBox();
        BUSCAR__ = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();
        LIMPIAR__ = new javax.swing.JButton();
        IMPRIMIR__ = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        despachos = new javax.swing.JTable();
        REGISTRAR__ = new javax.swing.JButton();
        SALIR__ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));

        jLabel3.setText("Fecha de Entrega:");

        jLabel4.setText("Zona:");

        Item.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Norte", "Sur", "Este", "Oeste", "Centro" }));

        BUSCAR__.setText("Buscar");
        BUSCAR__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCAR__ActionPerformed(evt);
            }
        });

        LIMPIAR__.setText("limpiar");
        LIMPIAR__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LIMPIAR__ActionPerformed(evt);
            }
        });

        IMPRIMIR__.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono_impresora.png"))); // NOI18N
        IMPRIMIR__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMPRIMIR__ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(162, 162, 162)
                .add(BUSCAR__)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(LIMPIAR__)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel1Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jLabel4))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Item, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 165, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(IMPRIMIR__, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel3)
                            .add(fecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(8, 8, 8)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(Item, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(IMPRIMIR__))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(BUSCAR__)
                    .add(LIMPIAR__))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de los productos"));

        despachos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Direccion", "Nro del pedido", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(despachos);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 134, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        REGISTRAR__.setText("Registrar");
        REGISTRAR__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGISTRAR__ActionPerformed(evt);
            }
        });

        SALIR__.setText("Salir");
        SALIR__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIR__ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(REGISTRAR__, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(31, 31, 31)
                .add(SALIR__, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(11, 11, 11)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(SALIR__)
                    .add(REGISTRAR__))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SALIR__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIR__ActionPerformed
       administrador ventana = new administrador();
       ventana.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_SALIR__ActionPerformed

    private void IMPRIMIR__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMPRIMIR__ActionPerformed

class MiPrintable implements Printable 
{
   public int print (Graphics g, PageFormat f, int pageIndex) 
   {
      if (pageIndex == 0) 
      {
         // Imprime "Hola mundo" en la primera pagina, en la posicion 100,100
         g.drawString("Hola mundo", 100,100);
         return PAGE_EXISTS;
      }
      else
         return NO_SUCH_PAGE;
   }
}


PrinterJob job = PrinterJob.getPrinterJob();
job.setPrintable( new MiPrintable());
try 
{
   job.print();
} 
catch (PrinterException e) 
{
   e.printStackTrace();
}

// Diálogo para elegir el formato de impresión
PageFormat pageFormat = new PageFormat();
pageFormat=job.pageDialog(pageFormat);

// Diálogo para confirmar impresion.
// Devuelve true si el usuario decide imprimir.
if (job.printDialog())
        try {
            job.print();
        } catch (PrinterException ex) {
            Logger.getLogger(despachos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_IMPRIMIR__ActionPerformed

    private void REGISTRAR__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTRAR__ActionPerformed
        String fecha_texto;
      
     // String fecha = fecha.getText();
        
        String format = fecha.getDateFormatString();
        Date date = fecha.getDate();
        SimpleDateFormat sdf =new SimpleDateFormat(format);
        fecha_texto = String.valueOf(sdf.format(date));
       
        
        try {
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usr, pwd);   
            
            String sql = "INSERT INTO despacho (id_despacho,fecha_despacho)  values (NULL,'"+fecha_texto+"')";
            

            sentencia = conexion.prepareStatement(sql);
            int result = sentencia.executeUpdate();
            
            if (result == 1){
                JOptionPane.showMessageDialog(null,"Se ha registrado los datos con exito");
                String sq = "update  detalle_pedido d, pedido p set (d.estado= 'despachado') where (p.pedido_id=d.pedido_id)";
                sent = conexion.prepareStatement(sql);
                int resultad = sent.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null,"No se han ingreado datos");
                
            }   
            
            
        }catch(Exception e) {
                System.out.println("Error al guardar los datos"+e);
        }         
        
    }//GEN-LAST:event_REGISTRAR__ActionPerformed

    private void BUSCAR__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCAR__ActionPerformed
     String fecha_texto;
     String item;
           try {
            
            String formato = fecha.getDateFormatString();
            Date date = fecha.getDate();
            SimpleDateFormat sdf =new SimpleDateFormat(formato);
            fecha_texto = String.valueOf(sdf.format(date));
           
            Item.getSelectedItem().toString();
           
            
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/programacion","root","");
            ps = cn.prepareStatement("SELECT p.cliente, c.direccion, d.pedido_id, SUM(total) \n" +
"                                 FROM pedido p, cliente c, detalle_pedido d \n" +
"                                 WHERE (p.pedido_id = d.pedido_id) and (p.fecha_entrega = '"+fecha_texto+"') \n" +
"                                 and (c.zona='"+Item.getSelectedItem().toString()+"')\n" +
"                                 group by d.pedido_id");   

            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            System.out.println(fecha_texto);
               System.out.println(Item.getSelectedItem().toString());
            while (rs.next()) {                
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i]=rs.getObject(i+1);                    
                }
                datos.add(rows);
            }
            dtm = (DefaultTableModel) this.despachos.getModel();
            for (int i = 0; i < datos.size(); i++) {
                dtm.addRow(datos.get(i));           
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }            
    }//GEN-LAST:event_BUSCAR__ActionPerformed

    private void LIMPIAR__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LIMPIAR__ActionPerformed
     
        try{
            DefaultTableModel temp = (DefaultTableModel) despachos.getModel();
            int a= temp.getRowCount();
            for( int i=a-1; i>=0; i--)
                temp.removeRow(0);
                rows = null;
                datos = new ArrayList < Object[]>();
                
            }catch (Exception e){
                System.out.println(e);
            }
    }//GEN-LAST:event_LIMPIAR__ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new despachos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUSCAR__;
    private javax.swing.JButton IMPRIMIR__;
    private javax.swing.JComboBox Item;
    private javax.swing.JButton LIMPIAR__;
    private javax.swing.JButton REGISTRAR__;
    private javax.swing.JButton SALIR__;
    private javax.swing.JTable despachos;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
