import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel gamePanel = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JLabel lbl_totalTorres = new JLabel();
    
    private int totalTorres = 0; 
    
    public Janela() {
        
        Dimension screenSize = Global.screen;
        setLayout( new BorderLayout() );
        
        setSize(800, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation( (screenSize.width - getWidth())/2, (screenSize.height - getHeight())/2 );
        
        gamePanel.addMouseListener( MouseHandler.mouseHandler );
        gamePanel.addMouseMotionListener( MouseHandler.mouseHandler );
        
        infoPanel.add( lbl_totalTorres ); 
        
        add(gamePanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);
        
    }
    
    public JPanel getGamePanel() {
        return gamePanel;
    }
    
    
    public void incTotalTorres() {
        totalTorres++;
        lbl_totalTorres.setText("Torres: " + totalTorres);
    }
    /*
    public void setPoints(String msg) {
        pointLabel.setText(msg);
    }//*/
    
}
