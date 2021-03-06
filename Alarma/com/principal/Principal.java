package com.Principal;

import com.operaciones.Operations;
import com.operaciones.SetAlarma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public final class Principal extends JFrame implements ActionListener {

    public JLabel lblReloj;
    private JButton btnLoadSong;
    public JCheckBox chkActive;
    public int _hora=-1, _minuto=-1, _segundo=-1;
    public boolean estaSonando = false;

    public Principal() {
        initComponents();
    }

    public static void main(String[] args) {
        Principal app = new Principal();
    }

    public void initComponents() {
        this.setTitle("Alarma para cualquier cosa");

        this.setSize(300, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblReloj = new JLabel("Martes 07 de Mayo del 2019 09:47:00");
        lblReloj.setBounds(5, 5, 290, 25);
        this.add(lblReloj);
        
        btnLoadSong = new JButton("Load song");
        btnLoadSong.setActionCommand("load");
        btnLoadSong.addActionListener(this);
        btnLoadSong.setBounds(5, 30, 125, 25);
        this.add(btnLoadSong);

        chkActive = new JCheckBox("Active Alarma");
        chkActive.setBounds(130, 30, 125, 25);
        this.add(chkActive);
        
        this.setVisible(true);
        loadHour();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("load".equals(e.getActionCommand())) {
            SetAlarma setAlarm = new SetAlarma(this);
        }
    }

    public void loadHour() {
        Operations op = new Operations(this);
        op.getHora();
    }
}
