/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import DAO.DichVuDAO;
import DAO.TaiKhoanDAO;
import com.google.gson.Gson;
import entity.DichVu;
import entity.TaiKhoan;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import utils.DynamicArray;
import utils.SendDatabase;
import utils.ServerThread;

/**
 *
 * @author duong
 */
public class ServerForm extends javax.swing.JFrame {
   
    /**
     * Creates new form NewJFrame
     */
    
    
    public ServerForm() throws InterruptedException {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

//        setExtendedState(JFrame.EXIT_ON_CLOSE);
        utils.Server.startServer();

    }
    
    private static String API;
    public static ServerThread curentClient;
    private static DynamicArray<ServerThread> listClients = utils.Server.clientSockets;
    private static DynamicArray<JLabel> clientLabels = new DynamicArray<>();

    
    
    public static void MoMay(){
        for(ServerThread client : listClients){ 
            if(client.getNumberClient() == 0){
                client.getOut().println(API);
            } 
        }
    }
    
    public static void sendTaiKhoan(){
        curentClient = listClients.get(0);
        TaiKhoanDAO tkdao = new TaiKhoanDAO();
        DichVuDAO dvdao = new DichVuDAO();
        List<TaiKhoan> listAccount = tkdao.selectAll();
        List<DichVu> listDV = dvdao.selectAll();
        Gson gson = new Gson();
        String API = gson.toJson(listAccount+"-"+listDV);
        curentClient.getOut().println("sendAccount-"+API);
    }
    
    
    
//    private void addClientLabels() {
//        SwingUtilities.invokeLater(() -> {
//            try {
//
//                for (ServerThread client : listClients) {
//                    JLabel clientLabel = createClientLabel(client);
//                    clientLabels.add(clientLabel);
//                    System.out.println("Adding client labels");
//                }
//
//                jPanel1.revalidate();
//                jPanel1.repaint();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
    
//    private JLabel createClientLabel(ServerThread client) {
//        JLabel label = new JLabel("Client " + client.getName());
//        label.setSize(40,40);
//        label.setBackground(Color.red);
//
//        // Đặt tên cho label để sử dụng khi click vào
//        label.setName(client.getName());
//
//        // Sử dụng MouseAdapter để lắng nghe sự kiện click
//        label.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                // Lấy tên của máy client khi click vào label
//                String clientName = label.getName();
//                System.out.println("Clicked on client: " + clientName);
//            }
//        });
//
//        return label;
//    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txt_API = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_API.setText("Server");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_API, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(txt_API))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        API = txt_API.getText();
//        addClientLabels();
        sendTaiKhoan();
//        MoMay();
  
       
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ServerForm().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_API;
    // End of variables declaration//GEN-END:variables
}
