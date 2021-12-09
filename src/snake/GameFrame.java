package snake;

public class GameFrame extends javax.swing.JFrame{
    GameJpanel Snake ;
    char Key = 'R';
    public GameFrame() {
        initComponents();
        Snake = new GameJpanel();
        this.setLocationRelativeTo(null);
        this.add(Snake);
        this.setVisible(true);
        this.setSize(Snake.W+114,Snake.H+37);
        Start.addKeyListener(Snake.e);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Start = new javax.swing.JButton();
        Level = new javax.swing.JComboBox<>();
        newGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Start.setText("Start");
        Start.setMaximumSize(new java.awt.Dimension(55, 21));
        Start.setMinimumSize(new java.awt.Dimension(50, 21));
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        Level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1", "Level 2", "Level 3", "Level 4" }));
        Level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LevelActionPerformed(evt);
            }
        });

        newGame.setText("newGame");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 312, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Start, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Level, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newGame)
                .addGap(18, 18, 18)
                .addComponent(Level, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        Start.addKeyListener(Snake.e);
        if (Snake.getStop()) {
            Snake.setStop(false);
            Start.setText("Continue");
        } else {
             Snake.setStop(true);
             Start.setText("Stop");
        }
    }//GEN-LAST:event_StartActionPerformed

    private void LevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LevelActionPerformed
        String level = (String) Level.getSelectedItem();
        this.remove(Snake);
        Snake = new GameJpanel();
        switch(level){
            case "Level 1":Snake.level = 1;break;
            case "Level 2":Snake.level = 2;break;
            case "Level 3":Snake.level = 3;break;
            case "Level 4":Snake.level = 4;break;
        }
        Snake.GameStart();
        this.add(Snake);
        Start.setText("Start");      
    }//GEN-LAST:event_LevelActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        String level = (String) Level.getSelectedItem();
        this.remove(Snake);
        Snake = new GameJpanel();
        switch(level){
            case "Level 1":Snake.level = 1;break;
            case "Level 2":Snake.level = 2;break;
            case "Level 3":Snake.level = 3;break;
            case "Level 4":Snake.level = 4;break;
        }
        Snake.GameStart();
        this.add(Snake);
        Start.setText("Start");
    }//GEN-LAST:event_newGameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Level;
    private javax.swing.JButton Start;
    private javax.swing.JButton newGame;
    // End of variables declaration//GEN-END:variables
}
