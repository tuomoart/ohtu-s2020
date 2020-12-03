/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.framework.junit.ApplicationTest;

/**
 *
 * @author tuomoart
 */
public class GraafinenLaskinTest extends ApplicationTest {
    private Parent rootNode;
    
    public GraafinenLaskinTest() {
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
            
        GraafinenLaskin nakyma = new GraafinenLaskin();
        pane.getChildren().add(nakyma);

        Scene scene = new Scene(pane, 200, 120);
        
        rootNode = scene.getRoot();
        
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1() {
        Button button = from(rootNode).lookup(".button").query();
        assertEquals("+", button.getText());
    }
}
