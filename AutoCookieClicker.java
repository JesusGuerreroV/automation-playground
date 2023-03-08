import java.awt.Robot;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.AWTException;
import java.awt.event.InputEvent;

public class AutoCookieClicker {

    public static void main(String[] args) throws AWTException, InterruptedException {
    	
        // PROCEDER CON PRECAUCION
    	
        Robot robot = new Robot();
        
        // coordenadas de donde se extrae el color de la galleta
        final int X = 215;
        final int Y = 325;

        // color de la galleta Web
        final int[] RGB = {82, 45, 39};
        
        // tolerancia rango
        final int TOLERANCIA = 50;
        
        System.out.println("Ejecutando!...");
        
        while (true) {
            // obtiene la posicion del puntero
            int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        	int mouseY = MouseInfo.getPointerInfo().getLocation().y;
           
            Color colorCoordenada = robot.getPixelColor(X, Y);
            Color colorGalleta = new Color(RGB[0], RGB[1], RGB[2]);
            
            // si en la coordenada especifica esta la galleta
            if (colorCoordenada.equals(colorGalleta)) {
            	
                // y si el mouse esta en la galleta
                if ((mouseX >= (X - TOLERANCIA) && mouseX <= (X + TOLERANCIA)) &&
                        (mouseY >= (Y - TOLERANCIA) && mouseY <= (Y + TOLERANCIA))) {
            		
                    // da click
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                }
            	
            }
            
        }

    }
}
