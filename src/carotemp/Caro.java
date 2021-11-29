/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carotemp;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Admin
 */
public class Caro extends javax.swing.JFrame {

    /**
     * Creates new form Caro
     */
    int x,y;
    JPanel p;
    JButton[][] bt;
    ArrayList<String> hangngang = new ArrayList<>();
    ArrayList<NgangDoc> hangdoc = new ArrayList();
    public Caro() {
        x=25;y=25;
        initComponents();
        this.setLocationRelativeTo(null);
        p = new JPanel();
        p.setBounds(0, 0, 500, 500);
        p.setLayout(new GridLayout(x, y));
        p.setBackground(new java.awt.Color(240, 240, 240));
        CaroPanel.add(p);
        bt = new JButton[x][y];
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                final int a=i , b=j;
                bt[a][b] = new JButton();
                //bt[a][b].setBackground(Color.BLACK);
                bt[a][b].setOpaque(true);
                bt[a][b].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));
                bt[a][b].setBorderPainted(true);
                bt[a][b].setContentAreaFilled(false);
                bt[a][b].setFocusable(false);
                bt[a][b].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        bt[a][b].setEnabled(false);
                        bt[a][b].setOpaque(true);
                        bt[a][b].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        bt[a][b].setBorderPainted(true);
                        bt[a][b].setContentAreaFilled(false);
                        bt[a][b].setFocusable(false);
                        bt[a][b].setBackground(Color.RED);
                        System.out.println(a+" ; "+b);
                        LuuNgang(b);
                        LuuDoc(b, a);
                        if((checkWinNgang(b, a)+checkWinNgang2(b, a))==6||
                                (checkWinthang(b, a)+checkWinthang2(b, a)==6)
                                ||(checkWinCheoChinh(b, a)+checkWinCheoChinh2(b, a)==6)
                                ||(checkWinCheoPhu(b, a)+checkWinCheoPhu2(b, a)==6))
                            System.out.println("You Win !");;
                        
                    }
                });
                p.add(bt[a][b]);
                p.setVisible(false);
                p.setVisible(true);
            }
        }
    }
    public void LuuNgang(int ngang)
    {
        int temp=0;
        if(hangngang.size()==0)
        {
            hangngang.add(ngang+"");
            System.out.println("Luu hang ngang : "+hangngang.size());
        }
        else{
            for(int i=0;i<hangngang.size();i++)
        {
            if(ngang!=Integer.parseInt(hangngang.get(i)))
            {
                temp++;
                if(temp==hangngang.size())
                {
                    hangngang.add(ngang+"");
                    System.out.println("Luu hang ngang : "+hangngang.size());
                }
            }
            
        }
        }
        
    }
    public void LuuDoc(int ngang , int doc)
    {
        int dem=0;
        if(hangdoc.size()==0)
        {
            
            NgangDoc tam=new NgangDoc(Integer.toString(ngang), Integer.toString(doc));
            hangdoc.add(tam);
            System.out.println(hangdoc.get(0).getDoc());
        }
        else{
            for(int i=0;i<hangdoc.size();i++)
            {
                if(ngang==Integer.parseInt(hangdoc.get(i).getNgang()))
                {
                        String temp=hangdoc.get(i).getDoc()+";"+doc;
                        hangdoc.get(i).setDoc(temp);
                        System.out.println(hangdoc.get(i).getNgang()+"   "+hangdoc.get(i).getDoc());
                }
                else{
                    dem++;
                    if(dem==hangdoc.size())
                    {
                        NgangDoc tam2=new NgangDoc(Integer.toString(ngang),Integer.toString(doc));
                        hangdoc.add(tam2);
                        System.out.println(hangdoc.get(i).getNgang()+"   "+hangdoc.get(i).getDoc());
                    }
                }
            }        
        }
    }
    
    public int checkWinNgang(int ngang , int doc)
    {
        int win=0;
        int temp=0;
        int temp2=ngang;
            while(temp<=5)
            {
                    for(int i=0;i<hangdoc.size();i++)
                {
                    if(temp2==Integer.parseInt(hangdoc.get(i).getNgang())&&
                            hangdoc.get(i).getDoc().contains(Integer.toString(doc)))
                    {
                            
                                win++;
                                System.out.println("Win Ngang : "+win);
                                temp2--;
        
                    }
                    
                }
                    temp++;
            }
            if(win>0)
                {
                        return win;
                }
        return 0;
    }
        public int checkWinNgang2(int ngang , int doc)
    {
        int win=0;
        int temp=0;
        int temp2=ngang;
            while(temp<=5)
            {
                    for(int i=0;i<hangdoc.size();i++)
                {
                    if(temp2==Integer.parseInt(hangdoc.get(i).getNgang())
                            &&hangdoc.get(i).getDoc().contains(Integer.toString(doc)))
                    {
                        win++;
                        System.out.println("Win Ngang: "+win);
                        temp2++;
                        
                    }
                    
                }
                    temp++;
                
            }
            if(win>0)
                    return win;
            
        
        return 0;
    }
        public int checkWinthang(int ngang , int doc)
        {
            int temp2=doc;
            int temp=0;
            int win=0;
            for(int i=0;i<hangdoc.size();i++)
            {
                if(ngang==Integer.parseInt(hangdoc.get(i).getNgang()))
                {
                    while(temp<=5){
                        if(hangdoc.get(i).getDoc().contains(Integer.toString(temp2)))
                        {
                            win++;
                            System.out.println("Win : "+win);
                            temp2++;
                        }
                        temp++;
                    }
                    if(win>0)
                        return win;
                    
                }
            }
            return 0;
        }
        public int checkWinthang2(int ngang , int doc)
        {
            int temp2=doc;
            int temp=0;
            int win=0;
            for(int i=0;i<hangdoc.size();i++)
            {
                if(ngang==Integer.parseInt(hangdoc.get(i).getNgang()))
                {
                    while(temp<=5){
                        if(hangdoc.get(i).getDoc().contains(Integer.toString(temp2)))
                        {
                            win++;
                            System.out.println("Win : "+win);
                            temp2--;
                        }
                        temp++;
                    }
                    if(win>0)
                        return win;
                    
                }
            }
            return 0;
        }
        public int checkWinCheoChinh(int ngang , int doc)
        {
            int temp=0;
            int temp2=ngang;
            int temp3=doc;
            int win=0;
            while(temp<=5)
            {
                for(int i=0;i<hangdoc.size();i++)
                {
                        if(temp2==Integer.parseInt(hangdoc.get(i).getNgang())
                            &&hangdoc.get(i).getDoc().contains(Integer.toString(temp3)))
                    {
                        win++;
                        System.out.println("Win Cheo: "+win);
                        temp2++;
                        temp3++;
                        
                    }                    
                }
                temp++;
            }
            if(win>0)
                return win;
            return 0;
        }
                public int checkWinCheoChinh2(int ngang , int doc)
        {
            int temp=0;
            int temp2=ngang;
            int temp3=doc;
            int win=0;
            while(temp<=5)
            {
                for(int i=0;i<hangdoc.size();i++)
                {
                        if(temp2==Integer.parseInt(hangdoc.get(i).getNgang())
                            &&hangdoc.get(i).getDoc().contains(Integer.toString(temp3)))
                    {
                        win++;
                        System.out.println("Win Cheo: "+win);
                        temp2--;
                        temp3--;
                        
                    }                    
                }
                temp++;
            }
            if(win>0)
                return win;
            return 0;
        }
                public int checkWinCheoPhu(int ngang , int doc)
                {
                    int temp=0;
                    int temp2=ngang;
                    int temp3=doc;
                    int win=0;
                    while(temp<=5)
                    {
                        for(int i=0;i<hangdoc.size();i++)
                        {
                                if(temp2==Integer.parseInt(hangdoc.get(i).getNgang())
                                    &&hangdoc.get(i).getDoc().contains(Integer.toString(temp3)))
                            {
                                win++;
                                System.out.println("Win Cheo: "+win);
                                temp2++;
                                temp3--;

                            }                    
                        }
                        temp++;
                    }
                    if(win>0)
                        return win;
                    return 0;
                }
                 public int checkWinCheoPhu2(int ngang , int doc)
                {
                    int temp=0;
                    int temp2=ngang;
                    int temp3=doc;
                    int win=0;
                    while(temp<=5)
                    {
                        for(int i=0;i<hangdoc.size();i++)
                        {
                                if(temp2==Integer.parseInt(hangdoc.get(i).getNgang())
                                    &&hangdoc.get(i).getDoc().contains(Integer.toString(temp3)))
                            {
                                win++;
                                System.out.println("Win Cheo: "+win);
                                temp2--;
                                temp3++;

                            }                    
                        }
                        temp++;
                    }
                    if(win>0)
                        return win;
                    return 0;
                }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        CaroPanel = new javax.swing.JPanel();
        SecondPanel = new javax.swing.JPanel();
        UserAPanel = new javax.swing.JPanel();
        UserBPanel = new javax.swing.JPanel();
        txtNameB = new javax.swing.JLabel();
        txtNameA = new javax.swing.JLabel();
        txtSend = new javax.swing.JTextField();
        SendButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CaroPanel.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout CaroPanelLayout = new javax.swing.GroupLayout(CaroPanel);
        CaroPanel.setLayout(CaroPanelLayout);
        CaroPanelLayout.setHorizontalGroup(
            CaroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        CaroPanelLayout.setVerticalGroup(
            CaroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        MainPanel.add(CaroPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SecondPanel.setBackground(new java.awt.Color(204, 204, 204));
        SecondPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout UserAPanelLayout = new javax.swing.GroupLayout(UserAPanel);
        UserAPanel.setLayout(UserAPanelLayout);
        UserAPanelLayout.setHorizontalGroup(
            UserAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        UserAPanelLayout.setVerticalGroup(
            UserAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        SecondPanel.add(UserAPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, 90));

        javax.swing.GroupLayout UserBPanelLayout = new javax.swing.GroupLayout(UserBPanel);
        UserBPanel.setLayout(UserBPanelLayout);
        UserBPanelLayout.setHorizontalGroup(
            UserBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        UserBPanelLayout.setVerticalGroup(
            UserBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        SecondPanel.add(UserBPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 70, 90));

        txtNameB.setText("UserB");
        SecondPanel.add(txtNameB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        txtNameA.setText("UserA");
        SecondPanel.add(txtNameA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));
        SecondPanel.add(txtSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 210, 60));

        SendButton.setBackground(new java.awt.Color(51, 153, 255));
        SendButton.setText("Send");
        SendButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SendButton.setContentAreaFilled(false);
        SendButton.setFocusable(false);
        SendButton.setOpaque(true);
        SendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SendButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SendButtonMouseReleased(evt);
            }
        });
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });
        SecondPanel.add(SendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 90, 60));
        SecondPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 300, 120));

        MainPanel.add(SecondPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 300, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
          //SendButton.setBackground(Color.yellow);
    }//GEN-LAST:event_SendButtonActionPerformed

    private void SendButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendButtonMousePressed
        // TODO add your handling code here:
        SendButton.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_SendButtonMousePressed

    private void SendButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendButtonMouseReleased
        // TODO add your handling code here:
        SendButton.setBackground(new Color(51, 153, 255));
    }//GEN-LAST:event_SendButtonMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Caro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new WindowsLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Caro.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Caro().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CaroPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel SecondPanel;
    private javax.swing.JButton SendButton;
    private javax.swing.JPanel UserAPanel;
    private javax.swing.JPanel UserBPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtNameA;
    private javax.swing.JLabel txtNameB;
    private javax.swing.JTextField txtSend;
    // End of variables declaration//GEN-END:variables
}
