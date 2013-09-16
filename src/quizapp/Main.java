package quizapp;

import java.util.Calendar;
import java.util.Scanner;
import static quizapp.CategoryQuestions.category;
import static quizapp.GeneralQuestions.general;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    public static String getQuestion() throws Exception {
        databaseResult db = new databaseResult("music");
        String s = "";
        while (db.getResult().next()) {
            if (db.getResult().getInt(1) == 3) {
                s = db.getResult().getString(2);
            }
        }

        return s;
    }
  
    public static String[] getOption() throws Exception {

        String option[] = new String[4];
        databaseResult db = new databaseResult("music");

        while (db.getResult().next()) {
            if (db.getResult().getInt(1) == 3) {
                option[0]=db.getResult().getString(4);
                option[1]=db.getResult().getString(5);
                option[2]=db.getResult().getString(6);
                option[3]=db.getResult().getString(7);
            }
        }
        return option;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Go");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Question");

        buttonGroup1.add(option1);

        buttonGroup1.add(option2);

        buttonGroup1.add(option3);

        buttonGroup1.add(option4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jButton1))
                            .addComponent(option2)
                            .addComponent(option1)
                            .addComponent(option3)
                            .addComponent(option4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(option1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    QuestionGeneration question[] = new QuestionGeneration[10];

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String question = getQuestion();
            String[] Option= getOption();
            
            question = "<html><p>"+question+"</p></html>";
            jLabel1.setText(question);
            option1.setText(Option[0]);
            option2.setText(Option[1]);
            option3.setText(Option[2]);
            option4.setText(Option[3]);
        } catch (Exception e) {
        };
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    // End of variables declaration//GEN-END:variables
}
